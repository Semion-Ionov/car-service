package omgtu.carservice.dto;

import com.google.gson.annotations.Expose;
import lombok.*;
import omgtu.carservice.model.Client;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseModel {
    @Expose
    private int status;

    @Expose
    private String token;

    @Expose
    private Client client;
}
