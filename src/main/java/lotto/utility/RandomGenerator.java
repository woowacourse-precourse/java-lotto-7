package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_TOTAL_NUMBER_COUNT = 6;

    public static List<Integer> makeRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_TOTAL_NUMBER_COUNT);
    }
}