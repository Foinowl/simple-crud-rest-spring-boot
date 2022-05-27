package rt.example.audio.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import rt.example.audio.dto.req.CreateMelodyRequest;
import rt.example.audio.dto.req.SearchMelodyRequest;
import rt.example.audio.dto.req.UpdateMelodyRequest;
import rt.example.audio.model.Melody;

@Validated
public interface MelodyService {
    long create(@Valid CreateMelodyRequest request);

    long update(@Valid UpdateMelodyRequest request);

    Melody findById(long id);

    List<Melody> findAll();

    List<Melody> search(@NotNull SearchMelodyRequest param);
}
