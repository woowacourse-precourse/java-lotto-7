package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static lotto.constants.LottoConstants.LOWER_BOUND;
import static lotto.constants.LottoConstants.UPPER_BOUND;
import static lotto.constants.LottoConstants.NUMBERS_PER_LOTTO;


public class LottoNumbersGenerator implements NumberGenerator {

    public List<Integer> generateNumbers() {
        return  Randoms.pickUniqueNumbersInRange(
                LOWER_BOUND.getValue()
                ,UPPER_BOUND.getValue()
                ,NUMBERS_PER_LOTTO.getValue());
    }
}
