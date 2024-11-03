package lotto;

import static lotto.LottoRule.NUMBER_LENGTH;
import static lotto.LottoRule.RANGE_HIGH;
import static lotto.LottoRule.RANGE_LOW;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * LottoMachine
 */
public class LottoMachine {

    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(RANGE_LOW, RANGE_HIGH, NUMBER_LENGTH);
        return new Lotto(numbers);
    }

}
