package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    public static final String MIN_LOTTO_NUMBER = "1";
    public static final String MAX_LOTTO_NUMBER = "45";

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
