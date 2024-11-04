package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator {
    private final int START = 1;
    private final int END = 45;
    private final int COUNT = 6;

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START, END, COUNT);
    }
}
