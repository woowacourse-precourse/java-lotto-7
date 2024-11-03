package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class UniqueNumberGenerator {
    private final int startInclusive;
    private final int endInclusive;

    public UniqueNumberGenerator(int startInclusive, int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    public List<Integer> generate(int size) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, size);
    }
}
