package lotto.utils;

import static lotto.constants.Constants.LOTTO_NUMBER_COUNT;
import static lotto.constants.Constants.MAX_NUMBER;
import static lotto.constants.Constants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }
}
