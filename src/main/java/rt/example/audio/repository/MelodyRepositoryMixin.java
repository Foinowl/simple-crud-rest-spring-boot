package rt.example.audio.repository;

import java.util.List;
import rt.example.audio.dto.req.SearchMelodyRequest;
import rt.example.audio.model.Melody;

public interface MelodyRepositoryMixin {
    List<Melody> search(SearchMelodyRequest body);

}
