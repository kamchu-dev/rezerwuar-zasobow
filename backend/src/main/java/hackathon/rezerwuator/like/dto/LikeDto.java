package hackathon.rezerwuator.like.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class LikeDto {
    String id;
    Long userId;
    String resourceCode;
}
