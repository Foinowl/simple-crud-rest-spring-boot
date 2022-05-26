package rt.example.audio.dto.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateMelodyRequest {

    @NotNull
    @NotBlank
    private String name;

    private Date dateCreate;

    @NotNull
    private Long duration;

    private Long compositorId;

    @NotNull
    private Set<Long> musiciansId;
}
