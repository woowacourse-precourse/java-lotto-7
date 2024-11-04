package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.LottoConstants;

public class RandomNumbers {
    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_MIN_NUMBER,LottoConstants.LOTTO_MAX_NUMBER,LottoConstants.LOTTO_NUMBERS_COUNT);
    }
}
