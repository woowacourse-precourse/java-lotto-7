package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {

    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX, LOTTO_NUMBER_COUNT);
    }
}
