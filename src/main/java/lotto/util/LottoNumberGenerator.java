package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.lotto.LottoConstant;

import java.util.List;

public class LottoNumberGenerator{
    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.NUMBER_START_INCLUSIVE,
                LottoConstant.NUMBER_END_INCLUSIVE,
                LottoConstant.NUMBER_COUNT);
    }

}