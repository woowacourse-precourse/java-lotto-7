package service;

import domain.User;

public class UserService {

    public User init(int amount) {
        return new User(amount);
    }
}
