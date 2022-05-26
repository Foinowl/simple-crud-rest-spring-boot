package rt.example.audio.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "melody")
public class Melody {
    @Id
    private Long id;

    private String name;

    private Date date_create;

    private Long duration;

    @ManyToOne
    @JoinColumn(name = "compositor_id")
    private Compositor compositor;

    @ManyToMany
    @JoinTable(name = "melody_genres",
        joinColumns = @JoinColumn(name="melody_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "genres_id", referencedColumnName = "id")
    )
    private Set<Genres> genres;

    @ManyToMany
    @JoinTable(name = "melody_musician",
        joinColumns = @JoinColumn(name="melody_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "musician_id", referencedColumnName = "id")
    )
    private Set<Musician> musician;
}
