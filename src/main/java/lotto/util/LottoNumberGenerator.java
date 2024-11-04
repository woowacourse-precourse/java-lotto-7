package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.lotto.LottoConstants;

import java.util.List;

public class LottoNumberGenerator{
    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstants.NUMBER_START_INCLUSIVE,
                LottoConstants.NUMBER_END_INCLUSIVE,
                LottoConstants.NUMBER_COUNT);
    }

}