package hackathon.rezerwuator.profile.dto;

import hackathon.rezerwuator.wish.dto.WishDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyWishDto {

    private WishDto wish;
}
