package hackathon.rezerwuator.like.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class LikeDto {
    String id;
    Long userId;
    String resourceCode;
}
