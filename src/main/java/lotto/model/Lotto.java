package lotto.model;

import static lotto.constant.ExceptionMessage.INVALID_LOTTO_COUNT;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_DUPLICATE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    private final static int RANGE_START = 1;
    private final static int RANGE_END = 45;
    private final static int LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(INVALID_LOTTO_DUPLICATE.getMessage());
        }
    }

    public static Lotto randomCreate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, LOTTO_SIZE);
        return new Lotto(randomNumbers);
    }

}
