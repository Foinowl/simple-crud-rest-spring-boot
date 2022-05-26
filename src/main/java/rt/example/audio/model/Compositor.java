package rt.example.audio.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "compositor")
public class Compositor {
    @Id
    private Long id;

    private String name;

    private Date date_birth;

    private String bio;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "compositor")
    private Set<Melody> melodies;
}
