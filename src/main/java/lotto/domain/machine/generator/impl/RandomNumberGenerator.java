package lotto.domain.machine.generator.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.machine.generator.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int PICK_COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, PICK_COUNT);
    }

}
