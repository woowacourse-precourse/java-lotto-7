package lotto.model;

import java.util.List;

public class UserLotto {
    private final List<Integer> userNumber;

    public UserLotto(List<Integer> userNumber) {
        this.userNumber = userNumber.stream().sorted().toList();
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }
}
