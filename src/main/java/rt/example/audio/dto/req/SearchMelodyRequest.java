package rt.example.audio.dto.req;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchMelodyRequest {
    private String name;

    private Long artistId;

    private Long compositorId;

    private String genre;

    private int currentPage;
    private int showPerPage;
}
