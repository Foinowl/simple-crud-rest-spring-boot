package rt.example.audio.dto.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCompositorRequest {
    @NotNull
    @NotBlank
    private String name;

    private Date dateBirth;

    @NotNull
    @NotBlank
    private String bio;
}
