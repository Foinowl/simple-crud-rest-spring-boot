package rt.example.audio.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "melodies")
@Setter
@Getter
@Entity
@Table(name = "genres")
public class Genres {
    @Id
    private Long id;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
    private Set<Melody> melodies;
}
