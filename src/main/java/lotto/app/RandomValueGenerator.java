package lotto.app;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomValueGenerator {

    private static final int START_VALUE_INCLUSIVE = 1;
    private static final int END_VALUE_INCLUSIVE = 45;
    private static final int GENERATE_COUNT = 45;

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_VALUE_INCLUSIVE, END_VALUE_INCLUSIVE, GENERATE_COUNT);
    }
}
