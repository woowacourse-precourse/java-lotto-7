package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class RandomNumber {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private List<Integer> randomNumbers;

    private RandomNumber(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public static RandomNumber generate() {
        return new RandomNumber(
                Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE)
        );
    }

    public List<Integer> getRandomNumbers() {
        return Collections.unmodifiableList(randomNumbers);
    }
}
