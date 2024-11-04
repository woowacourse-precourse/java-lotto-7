package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoConstant;


public abstract class LottoGenerator {
    public static List<Integer> getLotto() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_NUMBER_MIN_RANGE,
                LottoConstant.LOTTO_NUMBER_MAX_RANGE,
                LottoConstant.LOTTO_NUMBER_COUNT);
    }
}
