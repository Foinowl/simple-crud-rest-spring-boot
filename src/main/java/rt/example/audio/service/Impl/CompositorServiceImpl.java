package rt.example.audio.service.Impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rt.example.audio.dto.req.CreateCompositorRequest;
import rt.example.audio.dto.req.UpdateCompositorRequest;
import rt.example.audio.exception.NotFoundEntityException;
import rt.example.audio.model.Compositor;
import rt.example.audio.repository.CompositorRepository;
import rt.example.audio.service.CompositorService;
import rt.example.audio.service.UtilService;

@Service
@AllArgsConstructor
public class CompositorServiceImpl implements CompositorService {

    private CompositorRepository compositorRepository;

    private UtilService utils;

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
        return utils.returnEntity(compositorRepository.findById(id).get(), "Compositor with id" + id + "not found");
    }

    @Override
    public List<Compositor> findAll() {
        return utils.returnEntity(compositorRepository.findAll(), "Couldn't find any compositors from domain");
    }
}
