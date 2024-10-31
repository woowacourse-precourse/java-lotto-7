package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    // 싱글톤 패턴
    private static final UserRepository instance = new UserRepository();

    private UserRepository() {

    }

    public static UserRepository getInstance() {
        return instance;
    }

    private final List<User> users = new ArrayList<>();

    public User save(User user) {
        users.add(user);
        return users.getLast();
    }

    public User findById(int id) {
        return users.get(id);
    }

    public void deleteAll() {
        users.clear();
    }


}
