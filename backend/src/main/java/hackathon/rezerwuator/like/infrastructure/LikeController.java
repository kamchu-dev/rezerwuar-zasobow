package hackathon.rezerwuator.like.infrastructure;

import hackathon.rezerwuator.like.LikesFacade;
import hackathon.rezerwuator.like.dto.LikeDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/like")
@AllArgsConstructor
class LikeController {
    LikesFacade reservationFacade;

    @GetMapping("/api/like")
    List<LikeDto> getAll(){
        return reservationFacade.getAll();
    }

    @GetMapping("/api/like/code/{resourceCode}")
    List<LikeDto> getAll(@PathVariable String resourceCode){
        return reservationFacade.getAll(resourceCode);
    }

    @PostMapping("/api/like")
    String reserve(@RequestBody LikeDto likeDto){
         reservationFacade.like(likeDto.getUserId(), likeDto.getResourceCode());
         return "{}";
    }

    @DeleteMapping("/api/unlike/{resourceCode}")
    void unlike(@PathVariable String resourceCode){
        reservationFacade.unlike(1L, resourceCode);
    }
}
