package lotto.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RandomNumbers {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> randomNumbers;

    private RandomNumbers(List<Integer> randomNumbers) {
        randomNumbers.sort(Comparator.naturalOrder());
        this.randomNumbers = randomNumbers;
    }

    public static RandomNumbers generate() {
        return new RandomNumbers(
                Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE)
        );
    }

    public List<Integer> getRandomNumbers() {
        return Collections.unmodifiableList(randomNumbers);
    }
}
