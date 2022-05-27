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
import rt.example.audio.dto.req.CreateCompositorRequest;
import rt.example.audio.dto.req.UpdateCompositorRequest;
import rt.example.audio.model.Compositor;
import rt.example.audio.service.CompositorService;

@RestController
@RequestMapping("/api/compositors")
@AllArgsConstructor
public class CompositorController {

    private CompositorService compositorService;


    @GetMapping
    public ResponseEntity<List<Compositor>> getCompositors() {
        return new ResponseEntity<>(compositorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compositor> getCompositor(@PathVariable("id") Long id) {
        return new ResponseEntity<>(compositorService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addCompositor(@RequestBody CreateCompositorRequest request) {
        return new ResponseEntity<>(compositorService.create(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Long> updateCompositor(@RequestBody UpdateCompositorRequest request) {
        return new ResponseEntity<>(compositorService.update(request), HttpStatus.OK);
    }
}
