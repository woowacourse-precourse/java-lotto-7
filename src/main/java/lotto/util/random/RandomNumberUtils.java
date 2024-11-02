package lotto.util.random;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberUtils {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_MAX_COUNT = 6;

    public static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_MAX_COUNT);
    }
}
