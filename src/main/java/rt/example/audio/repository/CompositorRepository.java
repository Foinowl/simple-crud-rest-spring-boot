package rt.example.audio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rt.example.audio.model.Compositor;

@Repository
public interface CompositorRepository extends CrudRepository<Compositor, Long> {
}
