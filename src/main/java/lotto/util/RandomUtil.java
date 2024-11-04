package lotto.util;

import static lotto.enums.Constants.LOTTO_NUMBER_MAXIMUM;
import static lotto.enums.Constants.LOTTO_NUMBER_MINIMUM;
import static lotto.enums.Constants.LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_MINIMUM.getValue(),
                LOTTO_NUMBER_MAXIMUM.getValue(),
                LOTTO_NUMBER_COUNT.getValue());
    }
}
