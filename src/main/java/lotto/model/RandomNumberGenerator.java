package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MINIMUM_RANDOM_VALUE = 1;
    private static final int MAXIMUM_RANDOM_VALUE = 45;
    private static final int LOTTO_SIZE = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_RANDOM_VALUE,
                MAXIMUM_RANDOM_VALUE,
                LOTTO_SIZE);
    }
}
