package hackathon.rezerwuator.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ResourceDto {
    String name;
    String description;
    String code;
    String qr;
    Integer likes;
    List<String> tags;
    boolean isTaken;
    boolean canLike;
}
