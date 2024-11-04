package lotto.service.generator;

import static lotto.common.LottoRule.LOTTO_END_NUMBER;
import static lotto.common.LottoRule.LOTTO_NUMBER_COUNTS;
import static lotto.common.LottoRule.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomTicketNumberGenerator implements TicketNumberGenerator {
    @Override
    public List<Integer> generateTicketNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_START_NUMBER.getValue(),
                LOTTO_END_NUMBER.getValue(),
                LOTTO_NUMBER_COUNTS.getValue()
        );
    }
}
