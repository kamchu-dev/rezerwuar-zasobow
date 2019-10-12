package hackathon.rezerwuator.resource;

import hackathon.rezerwuator.resource.dto.ResourceDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.UUID;

@Configuration
public class ResourceConfig {

    @Bean
    ResourceFacade getResourceFacade(ResourceRepository repository){
        ResourceFacade resourceFacade = new ResourceFacade(repository);
        ArrayList<ResourceDto> resourceDtos = new ArrayList<>();
        resourceDtos.add(new ResourceDto("Żemeł Jest Super",
                "Wcale tego sam nie napisał",
                UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        resourceDtos.add(new ResourceDto("Somsiedzi",
                "miejsce 4 jest pewne",
                UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        resourceDtos.add(new ResourceDto("Nowa książka somsiada",
                "Ciekawe skąd miał pieniążki",
                UUID.randomUUID().toString(), UUID.randomUUID().toString()));

        resourceDtos.forEach( resource -> resourceFacade.addResource(resource.getName(), resource.getDescription(), resource.getQr()));

        return resourceFacade;
    }
}
