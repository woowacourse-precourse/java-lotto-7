package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.NumberGenerator;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_NUMBER_INCLUDE = 1;
    private static final int MAX_NUMBER_INCLUDE = 45;
    private static final int NUMBER_INCLUDE_COUNT = 6;

    @Override
    public List<Integer> generateUnique() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER_INCLUDE, MAX_NUMBER_INCLUDE, NUMBER_INCLUDE_COUNT);
    }
}
