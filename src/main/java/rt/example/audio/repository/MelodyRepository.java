package rt.example.audio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rt.example.audio.model.Melody;

@Repository
public interface MelodyRepository extends CrudRepository<Melody, Long> {
}
