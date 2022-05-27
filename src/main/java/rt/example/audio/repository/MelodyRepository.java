package rt.example.audio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rt.example.audio.model.Melody;

@Repository
public interface MelodyRepository extends JpaRepository<Melody, Long>, MelodyRepositoryMixin {
}
