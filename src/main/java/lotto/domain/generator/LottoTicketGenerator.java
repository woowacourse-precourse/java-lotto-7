package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static lotto.constants.LottoConstants.RANDOM_MIN;
import static lotto.constants.LottoConstants.RANDOM_MAX;
import static lotto.constants.LottoConstants.NUMBER_OF_NUMBERS;

public class LottoTicketGenerator {

    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_MIN, RANDOM_MAX, NUMBER_OF_NUMBERS);
    }
}

