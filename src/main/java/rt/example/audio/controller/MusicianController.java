package rt.example.audio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rt.example.audio.dto.req.CreateMusicianRequest;
import rt.example.audio.dto.req.UpdateMusicianRequest;
import rt.example.audio.service.MusicianService;

@RestController
@RequestMapping("/api/musicians")
@RequiredArgsConstructor
public class MusicianController {
    MusicianService musicianService;

    @PostMapping
    public ResponseEntity<Long> addMusician(@RequestBody CreateMusicianRequest request) {
        return new ResponseEntity<>(musicianService.create(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Long> updateMusician(@RequestBody UpdateMusicianRequest request) {
        return new ResponseEntity<>(musicianService.update(request), HttpStatus.CREATED);
    }
}
