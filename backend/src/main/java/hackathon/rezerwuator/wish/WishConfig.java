package hackathon.rezerwuator.wish;

import hackathon.rezerwuator.wish.dto.WishDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.UUID;

@Configuration
public class WishConfig {

    @Bean
    WishFacade getWishFacade(WishRepository repository) {
        WishFacade wishFacade = new WishFacade(repository);
        ArrayList<WishDto> resourceDtos = new ArrayList<>();
        resourceDtos.add(new WishDto("Żemeł Jest Super",
                "Wcale tego sam nie napisał",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "113.50 $", "https://www.amazon.com/Java-Dummies-Computers-Barry-Burd/dp/1119175690"));
        resourceDtos.add(new WishDto("Somsiedzi",
                "miejsce 4 jest pewne",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "113.50 $", "https://www.amazon.com/Java-Dummies-Computers-Barry-Burd/dp/1119175690"));
        resourceDtos.add(new WishDto("Nowa książka somsiada",
                "Ciekawe skąd miał pieniążki",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "113.50 $", "https://www.amazon.com/Java-Dummies-Computers-Barry-Burd/dp/1119175690"));

        resourceDtos.forEach(resource -> wishFacade.addResource(resource.getName(), resource.getDescription(), resource.getQr(), "113.50 $", "https://www.amazon.com/Java-Dummies-Computers-Barry-Burd/dp/1119175690"));

        return wishFacade;
    }
}
