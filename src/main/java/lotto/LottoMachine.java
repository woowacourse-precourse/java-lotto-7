package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constant.LottoRange.*;

public class LottoMachine {

    public Lotto publishLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_RANGE.getValue(),
                MAX_LOTTO_RANGE.getValue(),
                LOTTO_SIZE.getValue());

        return new Lotto(numbers);
    }
}
