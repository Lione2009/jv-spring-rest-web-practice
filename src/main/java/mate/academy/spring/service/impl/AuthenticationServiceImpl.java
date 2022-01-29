package mate.academy.spring.service.impl;

import mate.academy.spring.model.User;
import mate.academy.spring.service.AuthenticationService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.util.HashUtil;

public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService;

    @Override
    public User register(String email, String password) {
        if (userService.findByEmail(email).isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            return userService.add(user);
        }
        throw new RuntimeException("User with this email is present in Db");
    }

    @Override
    public User login(String email, String password) {
        if (userService.findByEmail(email).isPresent()) {
            User user = userService.findByEmail(email).get();
            if (user.getPassword().equals(HashUtil.hashPassword(password, user.getSalt()))) {
                return user;
            }
        }
        throw new RuntimeException("Email or password is incorrect");
    }
}
