package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMaker {

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private static final int COUNT = 6;

    public static List<Integer> make() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM, MAXIMUM, COUNT)
                .stream()
                .sorted().toList();
    }
}
