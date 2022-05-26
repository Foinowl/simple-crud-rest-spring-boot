package rt.example.audio.service;

import rt.example.audio.dto.req.CreateMusicianRequest;
import rt.example.audio.dto.req.UpdateMusicianRequest;

public interface MusicianService {
    long create(CreateMusicianRequest musicianRequest);

    long update(UpdateMusicianRequest updateRequest);
}
