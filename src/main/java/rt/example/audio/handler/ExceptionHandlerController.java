package rt.example.audio.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rt.example.audio.exception.NotFoundEntityException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<String> throwNotFoundEntity(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
