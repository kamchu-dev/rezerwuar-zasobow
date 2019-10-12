package hackathon.rezerwuator.resource;

import hackathon.rezerwuator.like.LikesFacade;
import hackathon.rezerwuator.rent.RentFacade;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class ResourceFacade {

    ResourceRepository repository;
    RentFacade rentFacade;
    LikesFacade likeFacade;

    public ResourceDto getResource(String code){
        boolean isRented = rentFacade.isRented(code);
        return repository.findById(code)
                .map(entity -> new ResourceDto(entity.getName(),
                        entity.getDescription(),
                        entity.getCode(),
                        entity.getQr(),
                        entity.getTags(),
                        isRented))
                .orElse(null);
    }

    public List<ResourceDto> getResources(){
        return repository.findAll()
                .stream()
                .map(entity -> {
                    boolean isRented = rentFacade.isRented(entity.getCode());
                    boolean canLike = likeFacade.canLike(entity.getCode());

                    return new ResourceDto(entity.getName(),
                            entity.getDescription(),
                            entity.getCode(),
                            entity.getQr(),
                            entity.getTags(),
                            isRented);
                })
                .collect(toList());
    }

    public String addResource(String name, String description, String qr, List<String> tags){
        Resource resource = new Resource(name, description,tags, UUID.randomUUID().toString(), qr);
        repository.save(resource);
        return resource.getCode();
    }

    public ResourceDto getResourceByQr(String qr) {
        return repository.findByQr(qr)
                .map(entity -> {
                    boolean isRented = rentFacade.isRented(entity.getCode());
                    boolean canLike = likeFacade.canLike(entity.getCode());

                    return new ResourceDto(entity.getName(),
                            entity.getDescription(),
                            entity.getCode(),
                            entity.getQr(),
                            entity.getTags(),
                            isRented);
                })
                .orElse(null);
    }
}
