package lotto.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class UserNumber {
    private List<Integer> userNumber;

    public UserNumber(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

}
