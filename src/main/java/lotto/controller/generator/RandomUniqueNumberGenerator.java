package lotto.controller.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUniqueNumberGenerator implements NumberGenerator {

    private final int startInclusive;
    private final int endInclusive;

    public RandomUniqueNumberGenerator(final int startInclusive, final int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    @Override
    public List<Integer> generate(final int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
