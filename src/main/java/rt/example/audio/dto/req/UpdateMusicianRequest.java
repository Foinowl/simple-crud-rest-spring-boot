package rt.example.audio.dto.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class UpdateMusicianRequest {
    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    private Date dateBirth;

    private Date dateStart;

    private String bio;
}
