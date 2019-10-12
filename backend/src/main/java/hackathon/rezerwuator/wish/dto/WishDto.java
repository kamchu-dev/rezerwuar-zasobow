package hackathon.rezerwuator.wish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WishDto {
    String name;
    String description;
    String code;
    String qr;
    String price;
    String url;
    Integer likes;
    boolean canLike;
}
