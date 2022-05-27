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
import rt.example.audio.dto.req.CreateMelodyRequest;
import rt.example.audio.dto.req.UpdateMelodyRequest;
import rt.example.audio.model.Melody;
import rt.example.audio.service.MelodyService;

@RestController
@RequestMapping("/api/melodies")
@AllArgsConstructor
public class MelodyController {
    private MelodyService melodyService;

    @GetMapping
    public ResponseEntity<List<Melody>> getCompositors() {
        return new ResponseEntity<>(melodyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Melody> getCompositor(@PathVariable("id") Long id) {
        return new ResponseEntity<>(melodyService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addMelody(@RequestBody CreateMelodyRequest request) {
        return new ResponseEntity<>(melodyService.create(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Long> updateMelody(@RequestBody UpdateMelodyRequest request) {
        return new ResponseEntity<>(melodyService.update(request), HttpStatus.CREATED);
    }
}
