package hackathon.rezerwuator.resource;

import hackathon.rezerwuator.like.LikesFacade;
import hackathon.rezerwuator.rent.RentFacade;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@Configuration
public class ResourceConfig {

    @Bean
    ResourceFacade getResourceFacade(ResourceRepository repository, @Lazy RentFacade rentFacade, LikesFacade likesFacade){
        ResourceFacade resourceFacade = new ResourceFacade(repository, rentFacade, likesFacade);
        ArrayList<ResourceDto> resourceDtos = new ArrayList<>();
        resourceDtos.add(new ResourceDto("Żemeł Jest Super",
                "Wcale tego sam nie napisał",
                "stalykod", UUID.randomUUID().toString(),  Arrays.asList("Żemeł tego nie pisał","Fajność","Klasa","Szyk"), true
                ));
        resourceDtos.add(new ResourceDto("Somsiedzi",
                "miejsce 4 jest pewne",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                Arrays.asList("Winners","Somsiedzi","Jak Już Co Robić To Bylejak"),
                false));
        resourceDtos.add(new ResourceDto("Nowa książka somsiada",
                "Ciekawe skąd miał pieniążki",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), Arrays.asList("Niepewność","UprzejmieDonosze"), false));

        resourceDtos.add(new ResourceDto("Cola",
                "Z hackatonu",
                "5449000000286", "5449000000286", Arrays.asList("Ambrozja", "Smak"), false));
        resourceDtos.add(new ResourceDto("Dubiel",
                "Najlepszy tester i QA",
                "1234567890128", "1234567890128",Arrays.asList("Gruby"), false));
        resourceDtos.add(new ResourceDto("szesc",
                "Najlepszy tester i QA",
                "1234567890144", "1234567890128",Arrays.asList("szesc"), false));
        resourceDtos.forEach( resource -> resourceFacade.addResource(resource.getName(), resource.getDescription(), resource.getQr(),resource.getTags()));

        return resourceFacade;
    }
}
