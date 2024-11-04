package lotto.random;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomImpl implements Random {

    @Override
    public List<Integer> pickUniqueNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBER_COUNT);
    }
}
