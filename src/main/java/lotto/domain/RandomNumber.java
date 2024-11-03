package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumber {
    public static Integer START_NUMBER = 1;
    public static Integer END_NUMBER = 45;
    public static Integer LOTTO_LENGTH = 6;

    private RandomNumber() {
    }

    public static List<Integer> make() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_LENGTH);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

}
