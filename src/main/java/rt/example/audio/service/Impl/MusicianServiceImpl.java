package rt.example.audio.service.Impl;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rt.example.audio.dto.req.CreateMusicianRequest;
import rt.example.audio.dto.req.UpdateMusicianRequest;
import rt.example.audio.exception.NotFoundEntityException;
import rt.example.audio.model.Musician;
import rt.example.audio.repository.MusicianRepository;
import rt.example.audio.service.MusicianService;


@Validated
@Service
public class MusicianServiceImpl implements MusicianService {

    @Autowired
    MusicianRepository musicianRepository;

    @Override
    public long create(@Valid CreateMusicianRequest musicianRequest) {

        Musician entity = new Musician();
        entity.setBio(musicianRequest.getBio());
        entity.setDateBirth(musicianRequest.getDateBirth());
        entity.setName(musicianRequest.getName());
        entity.setDateStart(musicianRequest.getDateStart());
        musicianRepository.save(entity);
        return entity.getId();
    }

    @Override
    public long update(@Valid UpdateMusicianRequest updateRequest) {
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

    public Musician findById(long id) {
        return musicianRepository.findById(id)
            .orElseThrow(() -> new NotFoundEntityException("Musician with id" + id + "not found"));
    }
}
