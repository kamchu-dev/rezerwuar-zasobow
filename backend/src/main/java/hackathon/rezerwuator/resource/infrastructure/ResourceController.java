package hackathon.rezerwuator.resource.infrastructure;


import hackathon.rezerwuator.resource.ResourceFacade;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController("/api/resources")
@AllArgsConstructor
class ResourceController {

    ResourceFacade facade;

    @GetMapping("/api/resources")
    public List<ResourceDto> getResources(){
        return facade.getResources();
    }

    @PostMapping("/api/resources")
    public String addResource(String name, String description, String qr){
        return facade.addResource(name, description, qr);
    }

    @GetMapping("/api/resource")
    public ResourceDto getResource(@RequestParam String code){
        return facade.getResource(code);
    }
}
