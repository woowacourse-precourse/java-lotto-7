package lotto.model;

import java.util.Comparator;
import java.util.List;

public class UserNumber {
    private final List<Integer> userNumber;

    public UserNumber(List<Integer> userNumber) {
        List<Integer>sortUserNumber = userNumber.stream().sorted().toList();
        this.userNumber = sortUserNumber;
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

}
