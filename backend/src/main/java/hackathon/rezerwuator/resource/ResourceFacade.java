package hackathon.rezerwuator.resource;

import hackathon.rezerwuator.resource.dto.ResourceDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class ResourceFacade {

    ResourceRepository repository;

    public ResourceDto getResource(String code){
        return repository.findById(code)
                .map(entity -> new ResourceDto(entity.getName(),
                        entity.getDescription(),
                        entity.getCode(),
                        entity.getQr()))
                .orElse(null);
    }

    public List<ResourceDto> getResources(){
        return repository.findAll()
                .stream()
                .map(entity -> new ResourceDto(entity.getName(),
                        entity.getDescription(),
                        entity.getCode(),
                        entity.getQr()))
                .collect(toList());
    }

    public String addResource(String name, String description, String qr){
        Resource resource = new Resource(name, description, UUID.randomUUID().toString(), qr);
        repository.save(resource);
        return resource.getCode();
    }
}
