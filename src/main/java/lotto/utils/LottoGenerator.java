package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int COUNT = 6;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT)
                .stream()
                .sorted()
                .toList();
    }

}
