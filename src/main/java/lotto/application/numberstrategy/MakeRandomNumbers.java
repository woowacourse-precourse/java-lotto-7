package lotto.application.numberstrategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.application.MakeNumbersStrategy;

public class MakeRandomNumbers implements MakeNumbersStrategy {
    @Override
    public List<Integer> makeNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
