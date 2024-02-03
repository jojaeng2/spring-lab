package argumentresolver.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

    @GetMapping("/user")
    public UserDto getUser(UserDto userDto) {
        log.warn("UserController userDto: {}", userDto.toString());
        return userDto;
    }
}
