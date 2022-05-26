package rt.example.audio.service.Impl;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rt.example.audio.dto.req.CreateCompositorRequest;
import rt.example.audio.dto.req.UpdateCompositorRequest;
import rt.example.audio.exception.NotFoundEntityException;
import rt.example.audio.model.Compositor;
import rt.example.audio.repository.CompositorRepository;
import rt.example.audio.service.CompositorService;

@Service
@AllArgsConstructor
public class CompositorServiceImpl implements CompositorService {

    private CompositorRepository compositorRepository;

    @Override
    public long create(CreateCompositorRequest compositorRequest) {
        var entity = new Compositor();
        entity.setBio(compositorRequest.getBio());
        entity.setDateBirth(compositorRequest.getDateBirth());
        entity.setName(compositorRequest.getName());
        compositorRepository.save(entity);

        return entity.getId();
    }

    @Override
    public long update(UpdateCompositorRequest compositorRequest) {

        Compositor entity;
        try {
            entity = findById(compositorRequest.getId());
        } catch (NotFoundEntityException e) {
            entity = new Compositor();
        }


        entity.setBio(compositorRequest.getBio());
        entity.setDateBirth(compositorRequest.getDateBirth());
        entity.setName(compositorRequest.getName());
        compositorRepository.save(entity);

        return entity.getId();
    }

    @Override
    public Compositor findById(long id) {
        return compositorRepository.findById(id)
            .orElseThrow(() -> new NotFoundEntityException("Compositor with id" + id + "not found"));
    }
}
