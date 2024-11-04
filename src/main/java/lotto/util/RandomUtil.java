package lotto.util;

import static lotto.constant.LottoConstant.NUMBER_LENGTH;
import static lotto.constant.LottoConstant.NUMBER_RANGE_MAX;
import static lotto.constant.LottoConstant.NUMBER_RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                NUMBER_RANGE_MIN.getValue(),
                NUMBER_RANGE_MAX.getValue(),
                NUMBER_LENGTH.getValue());
    }
}
