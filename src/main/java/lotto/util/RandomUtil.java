package lotto.util;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_RANGE_MAX;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_RANGE_MIN.getValue(),
                LOTTO_NUMBER_RANGE_MAX.getValue(),
                LOTTO_NUMBER_COUNT.getValue());
    }
}
