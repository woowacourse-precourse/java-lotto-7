package lotto.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static lotto.enums.ErrorCause.NOT_FOUND_USER;

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
        try {
            return users.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(NOT_FOUND_USER.toString());
        }
    }

    public void deleteAll() {
        users.clear();
    }


}
