package rt.example.audio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rt.example.audio.model.Melody;

@Repository
public interface MelodyRepository extends JpaRepository<Melody, Long> {

    @Query(value = "SELECT m.* FROM melody as m left join melody_musician as mm " +
        "on m.id = mm.melody_id " +
        "left join melody_genres as mg on m.id = mg.melody_id " +
        "where ( mm.musician_id = :artistId or " +
        "mg.genres ilike ':genre' or m.compositor_id = :compositorId or " +
        "m.name ilike ':name' ) or " +
        "( mm.musician_id = :artistId and " +
        "mg.genres ilike ':genre' and m.compositor_id = :compositorId and " +
        "m.name ilike ':name' ) " +
        "group by m.id " +
        "order by m.id", nativeQuery = true)
    List<Melody> findAll(@Param("artistId") Long artistId, @Param("genre") String genre,
                         @Param("compositorId") Long compositorId, @Param("name") String name);
}