package lotto.service.strategy;

import static lotto.common.constants.LottoConstants.LOTTO_RANGE;
import static lotto.common.constants.LottoConstants.LOTTO_RANGE_END;
import static lotto.common.constants.LottoConstants.LOTTO_RANGE_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomStrategy implements DrawStrategy {
    public List<Integer> draw() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_RANGE);
    }
}
