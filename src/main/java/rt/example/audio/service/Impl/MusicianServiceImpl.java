package rt.example.audio.service.Impl;

import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rt.example.audio.dto.req.CreateMusicianRequest;
import rt.example.audio.dto.req.UpdateMusicianRequest;
import rt.example.audio.exception.NotFoundEntityException;
import rt.example.audio.model.Musician;
import rt.example.audio.repository.MusicianRepository;
import rt.example.audio.service.MusicianService;
import rt.example.audio.service.UtilService;


@Service
@AllArgsConstructor
public class MusicianServiceImpl implements MusicianService {

    private MusicianRepository musicianRepository;

    private UtilService utils;


    @Override
    public long create(CreateMusicianRequest musicianRequest) {

        Musician entity = new Musician();
        entity.setBio(musicianRequest.getBio());
        entity.setDateBirth(musicianRequest.getDateBirth());
        entity.setName(musicianRequest.getName());
        entity.setDateStart(musicianRequest.getDateStart());
        musicianRepository.save(entity);
        return entity.getId();
    }

    @Override
    public long update(UpdateMusicianRequest updateRequest) {
        Musician entity;
        try {
            entity = findById(updateRequest.getId());
        } catch (NotFoundEntityException e) {
            entity = new Musician();
        }

        entity.setName(updateRequest.getName());
        entity.setBio(updateRequest.getBio());
        entity.setDateBirth(updateRequest.getDateBirth());
        entity.setDateStart(updateRequest.getDateStart());
        musicianRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Musician findById(long id) {
        return musicianRepository.findById(id)
            .orElseThrow(() -> new NotFoundEntityException("Musician with id" + id + "not found"));
    }

    @Override
    public List<Musician> findAll() {
        return utils.returnEntity(musicianRepository.findAll(), "Couldn't find any musician from domain");
    }

    @Override
    public List<Musician> findByIds(Collection<Long> ids) {
        return utils.returnEntity(musicianRepository.findAllById(ids), "Couldn't find any musician from domain");
    }
}
