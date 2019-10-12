package hackathon.rezerwuator.wish;

import hackathon.rezerwuator.like.LikesFacade;
import hackathon.rezerwuator.wish.dto.WishDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.UUID;

@Configuration
public class WishConfig {

    @Bean
    WishFacade getWishFacade(WishRepository repository, LikesFacade likesFacade) {
        WishFacade wishFacade = new WishFacade(repository, likesFacade);
        ArrayList<WishDto> resourceDtos = new ArrayList<>();
        resourceDtos.add(new WishDto("Wysyłanie maili",
                "Wcale tego sam nie napisał",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "113.50 $", "https://www.amazon.com/Java-Dummies-Computers-Barry-Burd/dp/1119175690", 5, true));
        resourceDtos.add(new WishDto("Zdjęcia gdzie został zostawiony zasób",
                "miejsce 4 jest pewne",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "113.50 $", "https://www.amazon.com/Java-Dummies-Computers-Barry-Burd/dp/1119175690",5, true));
        resourceDtos.add(new WishDto("Informacje przez kogo zasób jest zajęty",
                "Ciekawe skąd miał pieniążki",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "113.50 $", "https://www.amazon.com/Java-Dummies-Computers-Barry-Burd/dp/1119175690", 5, true));

        resourceDtos.forEach(resource -> wishFacade.addResource(resource.getName(), resource.getDescription(), resource.getQr(), "113.50 $", "https://www.amazon.com/Java-Dummies-Computers-Barry-Burd/dp/1119175690"));

        return wishFacade;
    }
}
