package lotto.provider;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.model.LottoOption.*;

public class RandomUniqueNumbersProvider implements NumbersProvider {

    @Override
    public List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER_OF_RANGE.value(), MAX_NUMBER_OF_RANGE.value(), TOTAL_ELEMENT_COUNT.value());
    }
}
