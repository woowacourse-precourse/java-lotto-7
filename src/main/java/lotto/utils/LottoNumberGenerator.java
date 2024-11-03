package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constants.LottoConstants;

public class LottoNumberGenerator {

    public static List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(
                 LottoConstants.LOTTO_START_INCLUSIVE
                ,LottoConstants.LOTTO_END_INCLUSIVE
                ,LottoConstants.NUMBER_COUNT);
    }
}
