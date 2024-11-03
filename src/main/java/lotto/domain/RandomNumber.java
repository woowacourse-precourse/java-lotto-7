package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;

    private RandomNumber() {
    }

    public static List<Integer> make() {
        List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_LENGTH);
        List<Integer> randomNumbers = new ArrayList<>(pickedNumbers);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

}
