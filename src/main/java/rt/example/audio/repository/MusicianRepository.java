package rt.example.audio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rt.example.audio.model.Musician;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {
}