package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.LottoValue;

import java.util.List;

public class LottoMachine {
    public Lotto generate() {
        int min = LottoValue.MIN_RANGE_NUMBER.getValue();
        int max = LottoValue.MAX_RANGE_NUMBER.getValue();
        int count = LottoValue.SIZE.getValue();
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min, max, count);
        return new Lotto(numbers);
    }
}
