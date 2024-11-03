package lotto.model.db;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.UserId;

public class UserRepository {

    private static UserRepository userRepository;

    private final Map<UserId, User> USERS = new HashMap<>();

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
            return userRepository;
        }
        return userRepository;
    }

    public void save(User user) {
        USERS.put(user.getId(), user);
    }

    public User findById(UserId userId) {
        return USERS.get(userId);
    }
}
