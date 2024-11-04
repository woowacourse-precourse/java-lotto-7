package lotto.util;

import static lotto.constant.LottoConstant.*;

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
