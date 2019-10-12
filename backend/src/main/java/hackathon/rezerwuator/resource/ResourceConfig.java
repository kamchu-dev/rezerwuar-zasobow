package hackathon.rezerwuator.resource;

import hackathon.rezerwuator.like.LikesFacade;
import hackathon.rezerwuator.rent.RentFacade;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.UUID;

@Configuration
public class ResourceConfig {

    @Bean
    ResourceFacade getResourceFacade(ResourceRepository repository, @Lazy RentFacade rentFacade, LikesFacade likesFacade){
        ResourceFacade resourceFacade = new ResourceFacade(repository, rentFacade, likesFacade);
        ArrayList<ResourceDto> resourceDtos = new ArrayList<>();
        resourceDtos.add(new ResourceDto("Żemeł Jest Super",
                "Wcale tego sam nie napisał",
                "stalykod", UUID.randomUUID().toString(), 5, "Fajność,Klasa,Szyk", true,false
                ));
        resourceDtos.add(new ResourceDto("Somsiedzi",
                "miejsce 4 jest pewne",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                5,
                "Winners,Somsiedzi,JakJużCoRobićToByleJak",
                false,
                false));
        resourceDtos.add(new ResourceDto("Nowa książka somsiada",
                "Ciekawe skąd miał pieniążki",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), 5,"Niepewność,UprzejmieDonosze", false, true));

        resourceDtos.add(new ResourceDto("Cola",
                "Z hackatonu",
                "5449000000286", "5449000000286", 6,"Ambrozja,Smak", false, true));
        resourceDtos.add(new ResourceDto("Dubiel",
                "Najlepszy tester i QA",
                "1234567890128", "1234567890128", 6,"Gruby", false, true));
        resourceDtos.forEach( resource -> resourceFacade.addResource(resource.getName(), resource.getDescription(), resource.getQr(),resource.getTags()));

        return resourceFacade;
    }
}
