package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public static final int NUMBER_OF_NUMBERS = 6;
    public static final int RANDOM_MIN = 1;
    public static final int RANDOM_MAX = 45;

    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_MIN, RANDOM_MAX, NUMBER_OF_NUMBERS);
    }
}

