package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomPicker {
    private static final int RANDOM_NUM_MIN = 1;
    private static final int RANDOM_NUM_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    public static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_NUM_MIN, RANDOM_NUM_MAX, LOTTO_SIZE);
    }
}
