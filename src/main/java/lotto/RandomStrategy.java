package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomStrategy implements GenerateStrategy {
    private static final Integer START = 1;
    private static final Integer END = 45;
    private static final Integer RANGE = 6;

    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(START, END, RANGE);
    }
}
