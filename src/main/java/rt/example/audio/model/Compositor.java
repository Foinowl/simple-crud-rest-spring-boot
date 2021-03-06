package rt.example.audio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "compositor")
public class Compositor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "date_birth")
    private Date dateBirth;

    private String bio;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "compositor")
    private Set<Melody> melodies;
}
