package hackathon.rezerwuator.wish;

import hackathon.rezerwuator.wish.dto.WishDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class WishFacade {

    WishRepository repository;

    public WishDto getResource(String code) {
        return repository.findById(code)
                .map(entity -> new WishDto(entity.getName(),
                        entity.getDescription(),
                        entity.getCode(),
                        entity.getQr(),
                        entity.getMoney(),
                        entity.getUrl()))
                .orElse(null);
    }

    public List<WishDto> getResources() {
        return repository.findAll()
                .stream()
                .map(entity -> new WishDto(entity.getName(),
                        entity.getDescription(),
                        entity.getCode(),
                        entity.getQr(),
                        entity.getMoney(),
                        entity.getUrl()))
                .collect(toList());
    }

    public String addResource(String name, String description, String qr, String money, String url) {
        Wish resource = new Wish(name, description, UUID.randomUUID().toString(), qr, money, url);
        repository.save(resource);
        return resource.getCode();
    }
}
