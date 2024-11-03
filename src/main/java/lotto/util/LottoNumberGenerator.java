package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public static final int LOTTO_RANGE_START = 1;
    public static final int LOTTO_RANGE_END = 45;
    public static final int LOTTO_COUNT_6 = 6;

    public static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_COUNT_6);
    }
}
