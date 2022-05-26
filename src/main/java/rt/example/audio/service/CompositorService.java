package rt.example.audio.service;

import rt.example.audio.dto.req.CreateCompositorRequest;
import rt.example.audio.dto.req.UpdateCompositorRequest;
import rt.example.audio.model.Compositor;

public interface CompositorService {
    long create(CreateCompositorRequest compositorRequest);

    long update(UpdateCompositorRequest compositorRequest);

    Compositor findById(long id);
}
