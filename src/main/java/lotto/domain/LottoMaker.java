package lotto.domain;

import static lotto.constant.Constant.NUMBERS_MAX_COUNT;
import static lotto.constant.Constant.NUMBERS_RANGE_END;
import static lotto.constant.Constant.NUMBERS_RANGE_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoMaker {

    public Lotto makeLotto() {
        List<Integer> numbers = new ArrayList<>
                (Randoms.pickUniqueNumbersInRange(NUMBERS_RANGE_START,
                        NUMBERS_RANGE_END, NUMBERS_MAX_COUNT));
        sortNumbers(numbers);

        return new Lotto(numbers);
    }

    private void sortNumbers(List<Integer> lotto) {
        Collections.sort(lotto);
    }
}
