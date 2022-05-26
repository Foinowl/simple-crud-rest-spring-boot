package rt.example.audio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "melodies")
@Setter
@Getter
@Entity
@Table(name = "artist")
public class Musician {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "date_birth")
    private Date dateBirth;

    @Column(name = "date_start")
    private Date dateStart;

    private String bio;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "musician")
    private Set<Melody> melodies;
}
