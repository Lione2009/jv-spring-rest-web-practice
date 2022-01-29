package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.service.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.request.UserRequestMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private UserRequestMapper userRequestMapper;
    private AuthenticationService authenticationService;

    public AuthenticationController(
            UserRequestMapper userRequestMapper,
            AuthenticationService authenticationService) {
        this.userRequestMapper = userRequestMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("register")
    public void register(@RequestBody UserRequestDto userRequestDto) {
        authenticationService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
    }
}
