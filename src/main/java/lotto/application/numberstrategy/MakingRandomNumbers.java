package lotto.application.numberstrategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.application.MakingNumbersStrategy;
import lotto.domain.Lotto;

public class MakingRandomNumbers implements MakingNumbersStrategy {
    @Override
    public List<Integer> makeNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.NUMBER_BEGIN_RANGE, Lotto.NUMBER_END_RANGE, Lotto.NUMBER_SIZE);
    }
}
