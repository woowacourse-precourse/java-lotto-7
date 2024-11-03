package lotto.strategy;

import static lotto.constant.LottoConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.NUMBERS_PER_TICKET;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;

public class QuickpickIssuanceStrategy implements IssuanceStrategy {
    @Override
    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MINIMUM_LOTTO_NUMBER,
                MAXIMUM_LOTTO_NUMBER,
                NUMBERS_PER_TICKET
        );
        
        return Lotto.from(numbers);
    }
}
