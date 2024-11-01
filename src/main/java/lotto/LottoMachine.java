package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * LottoMachine
 */
public class LottoMachine {

    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

}
