package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbers {
    private static final int MIN_LOTTO = 1;
    private static final int MAX_LOTTO = 45;
    private static final int COUNT = 6;
    public static List<Integer> getGenerateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO, MAX_LOTTO, COUNT);
    }
}