package hackathon.rezerwuator.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class RentRequestDto {
    String resourceCode;
    Long userId;
}
