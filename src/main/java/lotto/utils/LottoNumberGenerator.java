package lotto.utils;

import static lotto.constans.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constans.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.constans.LottoConstants.REQUIRED_LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, REQUIRED_LOTTO_NUMBER_COUNT);
    }
}
