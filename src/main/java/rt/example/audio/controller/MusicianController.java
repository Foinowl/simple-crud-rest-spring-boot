package rt.example.audio.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rt.example.audio.dto.req.CreateMusicianRequest;
import rt.example.audio.dto.req.UpdateMusicianRequest;
import rt.example.audio.model.Musician;
import rt.example.audio.service.MusicianService;

@RestController
@RequestMapping("/api/musicians")
@AllArgsConstructor
public class MusicianController {
    private MusicianService musicianService;

    @GetMapping("/{id}")
    public ResponseEntity<Musician> getMusicians(@PathVariable("id") Long id) {
        return new ResponseEntity<>(musicianService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Musician>> getMusician() {
        return new ResponseEntity<>(musicianService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addMusician(@RequestBody CreateMusicianRequest request) {
        return new ResponseEntity<>(musicianService.create(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Long> updateMusician(@RequestBody UpdateMusicianRequest request) {
        return new ResponseEntity<>(musicianService.update(request), HttpStatus.OK);
    }
}
