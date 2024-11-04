package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.constants.LottoConstants;

public class LottoNumberGenerator {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_MIN_NUMBER.getValue(),
                LottoConstants.LOTTO_MAX_NUMBER.getValue(),
                LottoConstants.LOTTO_SIZE.getValue()
        );
    }

}
