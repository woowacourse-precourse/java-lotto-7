package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MINIMUM_RANDOM_VALUE = 1;
    private static final int MAXIMUM_RANDOM_VALUE = 45;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_VALUE, MAXIMUM_RANDOM_VALUE);
    }
}
