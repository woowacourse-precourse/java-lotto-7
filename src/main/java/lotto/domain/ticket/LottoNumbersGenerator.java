package lotto.domain.ticket;

import static lotto.constants.LottoTicket.LOWER_BOUND;
import static lotto.constants.LottoTicket.NUMBERS_PER_LOTTO;
import static lotto.constants.LottoTicket.UPPER_BOUND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


public class LottoNumbersGenerator implements NumbersGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LOWER_BOUND.getValue()
                , UPPER_BOUND.getValue()
                , NUMBERS_PER_LOTTO.getValue());
    }
}
