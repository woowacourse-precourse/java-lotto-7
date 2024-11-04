package lotto.mock.number_generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RealRandomNumberGenerator extends MockedRandomNumberGenerator {
    public RealRandomNumberGenerator() {
    }

    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        lastGeneratedNumbers = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        return lastGeneratedNumbers;
    }
}
