CREATE OR REPLACE FUNCTION public.melody_search(
    OUT o_result refcursor,
    OUT o_total bigint,
    --
    p_query        text,
    p_room_count   int8[],
    p_price_from   float8,
    p_price_to     float8,
    p_not_first    bool,
    p_not_last     bool,
    --
    p_page integer,
    p_per_page integer
)
    RETURNS record
    LANGUAGE plpgsql
AS $function$
declare
l_temp   int8[];
    l_offset int8 := p_page * p_per_page;

    l_query  text := '';
begin

    l_query := '
        select array_agg(t.id)
          from t_buidling t
         where true
    ';

    if cardinality(p_room_count) > 0 then
        l_query := l_query || '
            and t.room_count = any($1)
        ';
end if;

    if p_price_from is not null then
        l_query := l_query || '
            and t.price >= $2
        ';
end if;

    if p_price_to is not null then
        l_query := l_query || '
            and t.price <= $3
        ';
end if;

    if p_not_first then
        l_query := l_query || '
            and t.floor > 1
            and t.floor_in_house > 1
        ';
end if;

    if p_not_last then
        l_query := l_query || '
            and t.floor < t.floor_in_house
        ';
end if;

    if p_query is not null then
        l_query := l_query || '
            and t.name ilike ''%''||$4||''%''
        ';
end if;


execute l_query into l_temp
    using /* 1 */ p_room_count,
        /* 2 */ p_price_from,
        /* 3 */ p_price_to,
        /* 4 */ p_query
;


o_total := coalesce(cardinality(l_temp), 0);

open o_result for
select t.*
from unnest(l_temp) f
         join t_buidling t
              on t.id = f
order by t.id
    limit p_per_page offset l_offset
;

end;
$function$
;
