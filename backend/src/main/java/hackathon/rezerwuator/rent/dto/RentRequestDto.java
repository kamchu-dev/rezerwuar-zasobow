package hackathon.rezerwuator.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RentRequestDto {
    String resourceCode;
    Long userId;
}
