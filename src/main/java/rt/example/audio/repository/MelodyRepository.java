package rt.example.audio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rt.example.audio.model.Melody;

@Repository
public interface MelodyRepository extends JpaRepository<Melody, Long> {


    //    @Query("select m from melodies m join m.musician mu where mu.id = :artistId")
//    List<Melody> search(@Param("name") String name, @Param("artistId") Long artistId, @Param("compositorId") Long compositorId,@Param("genre") String genre);
//}
    @Query(value = "SELECT * FROM melody as m left join melody_musician as mm " +
        "on m.id = mm.melody_id where mm.musician_id = :artistId", nativeQuery = true)
    List<Melody> findAll(@Param("artistId") Long artistId);
}