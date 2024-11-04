package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constants.LottoValue.*;

public class LottoNumbersGenerator implements NumbersGenerator {
    @Override
    public List<Integer> createNumbers() {
        int minRange = MIN_LOTTO_NUMBER_RANGE.getValue();
        int maxRange = MIN_LOTTO_NUMBER_RANGE.getValue();
        int numberCount = LOTTO_NUMBER_COUNT.getValue();
        return Randoms.pickUniqueNumbersInRange(minRange, maxRange, numberCount);
    }
}
