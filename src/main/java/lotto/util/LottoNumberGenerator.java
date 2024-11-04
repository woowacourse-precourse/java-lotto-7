package lotto.util;

import static lotto.constants.NumberConstants.LOTTO_COUNT_6;
import static lotto.constants.NumberConstants.LOTTO_RANGE_END;
import static lotto.constants.NumberConstants.LOTTO_RANGE_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_COUNT_6);
    }
}
