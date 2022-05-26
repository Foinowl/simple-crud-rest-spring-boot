package rt.example.audio.model;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(nullable = false)
    private Long duration;

    @ManyToOne
    @JoinColumn(name = "compositor_id")
    private Compositor compositor;

    @ElementCollection(targetClass = Genres.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "melody_genres",joinColumns = @JoinColumn(name = "melody_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genres> genres;

    @ManyToMany
    @JoinTable(name = "melody_musician",
        joinColumns = @JoinColumn(name="melody_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "musician_id", referencedColumnName = "id")
    )
    @Column(nullable = false)
    private Set<Musician> musician;
}
