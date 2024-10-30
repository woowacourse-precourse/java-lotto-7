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

    public void save(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public void deleteAll() {
        users.clear();
    }


}
