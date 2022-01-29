package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;

public class UserRequestMapper {
    public User toModel(UserRequestDto userRequestDto) {
        User user = new User();
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        return user;
    }
}
