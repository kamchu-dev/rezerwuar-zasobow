package hackathon.rezerwuator.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResourceDto {
    String name;
    String description;
    String code;
    String qr;
    Integer likes;
    boolean isTaken;
    boolean canLike;
}
