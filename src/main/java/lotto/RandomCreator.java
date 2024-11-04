package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomCreator {

    private final int startRange;
    private final int endRange;
    private final int count;

    public RandomCreator(final int startRange, final int endRange, final int count) {
        this.startRange = startRange;
        this.endRange = endRange;
        this.count = count;
    }

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(startRange, endRange, count);
    }
}
