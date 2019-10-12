package hackathon.rezerwuator.wish.infrastructure;


import hackathon.rezerwuator.wish.WishFacade;
import hackathon.rezerwuator.wish.dto.WishDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wish")
@AllArgsConstructor
class WishController {

    WishFacade facade;

    @GetMapping
    public List<WishDto> getResources() {
        return facade.getResources();
    }

    @PostMapping
    public String addResource(String name, String description, String qr, String price, String url) {
        return facade.addResource(name, description, qr, price, url);
    }

    @GetMapping("/{code}")
    public WishDto getResource(@PathVariable("code") String code) {
        return facade.getResource(code);
    }
}
