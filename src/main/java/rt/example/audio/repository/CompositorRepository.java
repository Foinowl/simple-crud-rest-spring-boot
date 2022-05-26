package rt.example.audio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rt.example.audio.model.Compositor;

@Repository
public interface CompositorRepository extends JpaRepository<Compositor, Long> {
}
