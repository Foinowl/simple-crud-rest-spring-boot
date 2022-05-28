package rt.example.audio.service.Impl;

import java.util.HashSet;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rt.example.audio.dto.req.CreateMelodyRequest;
import rt.example.audio.dto.req.SearchMelodyRequest;
import rt.example.audio.dto.req.UpdateMelodyRequest;
import rt.example.audio.model.Genres;
import rt.example.audio.model.Melody;
import rt.example.audio.repository.MelodyRepository;
import rt.example.audio.service.CompositorService;
import rt.example.audio.service.MelodyService;
import rt.example.audio.service.MusicianService;
import rt.example.audio.service.UtilService;

@Service
@AllArgsConstructor
public class MelodiesServiceImpl implements MelodyService {

    private MelodyRepository melodyRepository;

    private CompositorService compositorService;

    private UtilService utils;


    private MusicianService musicianService;

    @Override
    public long create(CreateMelodyRequest request) {
        Melody entity = new Melody();

        entity.setName(request.getName());
        entity.setDateCreate(request.getDateCreate());
        entity.setDuration(request.getDuration());
        entity.setGenres(Genres.filterRequestGenres(request.getGenres()));
        entity.setCompositor(compositorService.findById(request.getCompositorId()));
        entity.setMusician(new HashSet<>(musicianService.findByIds(request.getMusiciansId())));
        melodyRepository.save(entity);
        return entity.getId();
    }

    @Override
    public long update(UpdateMelodyRequest request) {
        Melody entity = findById(request.getId());

        entity.setName(request.getName());
        entity.setDateCreate(request.getDateCreate());
        entity.setDuration(request.getDuration());
        entity.setGenres(Genres.filterRequestGenres(request.getGenres()));
        entity.setCompositor(compositorService.findById(request.getCompositorId()));
        entity.setMusician(new HashSet<>(musicianService.findByIds(request.getMusiciansId())));
        melodyRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Melody findById(long id) {
        return utils.returnEntity(melodyRepository.findById(id).get(), "Melody with id" + id + "not found");
    }

    @Override
    public List<Melody> findAll() {
        return utils.returnEntity(melodyRepository.findAll(), "Melodies not found");
    }

    @Override
    public List<Melody> search(SearchMelodyRequest param) {
        return melodyRepository.findAll(param.getArtistId(), param.getGenre(), param.getCompositorId(),
            param.getName());
    }
}
