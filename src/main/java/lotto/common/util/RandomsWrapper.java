package lotto.common.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsWrapper {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public static int getInt() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }
}
