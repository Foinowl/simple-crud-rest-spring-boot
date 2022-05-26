package rt.example.audio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rt.example.audio.model.Musician;

public interface MusicianRepository extends JpaRepository<Musician, Long> {
}