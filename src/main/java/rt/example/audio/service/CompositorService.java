package rt.example.audio.service;

import javax.validation.Valid;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import rt.example.audio.dto.req.CreateCompositorRequest;
import rt.example.audio.dto.req.UpdateCompositorRequest;
import rt.example.audio.model.Compositor;

@Validated
public interface CompositorService {
    long create(@Valid CreateCompositorRequest request);

    long update(@Valid UpdateCompositorRequest request);

    Compositor findById(long id);

    List<Compositor> findAll();
}
