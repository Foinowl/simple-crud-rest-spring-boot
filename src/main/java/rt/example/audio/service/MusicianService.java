package rt.example.audio.service;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.validation.annotation.Validated;
import rt.example.audio.dto.req.CreateMusicianRequest;
import rt.example.audio.dto.req.UpdateMusicianRequest;
import rt.example.audio.model.Musician;

@Validated
public interface MusicianService {
    long create(@Valid CreateMusicianRequest request);

    long update(@Valid UpdateMusicianRequest request);

    Musician findById(long id);

    List<Musician> findAll();

    List<Musician> findByIds(Collection<Long> ids);

}
