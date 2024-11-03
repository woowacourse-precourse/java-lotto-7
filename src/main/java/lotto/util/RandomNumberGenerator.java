package lotto.util;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.config.GameConstant.LOWER_BOUND_WINNING_NUMBER;
import static lotto.config.GameConstant.NUMBER_OF_WINNING_NUMBER;
import static lotto.config.GameConstant.UPPER_BOUND_WINNING_NUMBER;

import java.util.List;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }

    public static List<Integer> generateRandomNumbers() {
        return pickUniqueNumbersInRange(LOWER_BOUND_WINNING_NUMBER, UPPER_BOUND_WINNING_NUMBER,
                NUMBER_OF_WINNING_NUMBER);
    }
}
