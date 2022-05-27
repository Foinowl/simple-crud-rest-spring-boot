package rt.example.audio.repository;

import javax.persistence.EntityManager;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import rt.example.audio.dto.req.SearchMelodyRequest;
import rt.example.audio.model.Melody;

@AllArgsConstructor
public class MelodyRepositoryMixinImpl implements MelodyRepositoryMixin {

    private final EntityManager em;

    @Transactional
    @Override
    public List<Melody> search(SearchMelodyRequest body) {
        var query = em.createNamedStoredProcedureQuery("melody_search");

        int index = 3;
        query.setParameter(3, "you");
//        query.setParameter(index++, body.getArtistId());
//        query.setParameter(index++, body.getCompositorId());
//        query.setParameter(index++, body.getGenre());
//
//        query.setParameter(index++, body.getCurrentPage());
//        query.setParameter(index++, body.getShowPerPage());


        query.execute();

        var result = query.getResultList();
        var total = (Long) query.getOutputParameterValue(2);

        return result;
    }
}
