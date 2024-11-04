package lotto.generator;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int PICK_COUNT = 6;

    @Override
    public List<Integer> generateNumber() {
        return pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_COUNT)
                .stream()
                .sorted()
                .toList();
    }
}
