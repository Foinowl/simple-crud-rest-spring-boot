package rt.example.audio.service;

import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import rt.example.audio.exception.NotFoundEntityException;

@Service
public class UtilService {
    public <T> List<T> returnEntity(List<T> result, String err) {
        if (result.size() != 0) {
            return result;
        } else {
            throw new NotFoundEntityException(err);
        }
    }

    public <T> T returnEntity(T result, String err) {
        if (Objects.nonNull(result)) {
            return result;
        } else {
            throw new NotFoundEntityException(err);
        }
    }
}
