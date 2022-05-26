package rt.example.audio.service;

import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import rt.example.audio.dto.req.CreateCompositorRequest;
import rt.example.audio.dto.req.UpdateCompositorRequest;
import rt.example.audio.model.Compositor;

@Validated
public interface CompositorService {
    long create(@Valid CreateCompositorRequest compositorRequest);

    long update(@Valid UpdateCompositorRequest compositorRequest);

    Compositor findById(long id);
}
