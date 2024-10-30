package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constants.LottoValue.*;

public class LottoNumbersGenerator implements NumbersGenerator {
    @Override
    public List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER_RANGE.getValue(), MAX_LOTTO_NUMBER_RANGE.getValue(), LOTTO_NUMBER_COUNT.getValue());
    }
}
