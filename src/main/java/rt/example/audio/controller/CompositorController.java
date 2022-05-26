package rt.example.audio.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rt.example.audio.dto.req.CreateCompositorRequest;
import rt.example.audio.dto.req.UpdateCompositorRequest;
import rt.example.audio.service.CompositorService;

@RestController
@RequestMapping("/api/compositors")
@AllArgsConstructor
public class CompositorController {

    private CompositorService compositorService;

    @PostMapping
    public ResponseEntity<Long> addCompositor(@RequestBody CreateCompositorRequest request) {
        return new ResponseEntity<>(compositorService.create(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Long> updateBook(@RequestBody UpdateCompositorRequest request) {
        return new ResponseEntity<>(compositorService.update(request), HttpStatus.CREATED);
    }
}
