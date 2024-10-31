package lotto.common.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsWrapper {
    private static final int MIN_LANGE = 1;
    private static final int MAX_LANGE = 45;

    public static int getInt() {
        return Randoms.pickNumberInRange(MIN_LANGE, MAX_LANGE);
    }
}
