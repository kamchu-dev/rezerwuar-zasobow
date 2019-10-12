package hackathon.rezerwuator.user.intrastructure;

import hackathon.rezerwuator.user.User;
import hackathon.rezerwuator.user.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User doesn't exists."));
    }

}
