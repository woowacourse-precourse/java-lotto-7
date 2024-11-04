package lotto.common;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator {

    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    public static List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(START, END, COUNT);
    }
}
