package hackathon.rezerwuator.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {

    private Long id;

    private String name;

    private String password;

}
