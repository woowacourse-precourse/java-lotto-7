package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.global.message.ErrorMessage;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        validate(numbers);
        return new Lotto(new ArrayList<>(numbers));
    }

    public static Lotto auto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MINIMUM_LOTTO_NUMBER,
                MAXIMUM_LOTTO_NUMBER,
                LOTTO_SIZE);
        return new Lotto(numbers);
    }

    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE);
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    private static void validateNumberInRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private static boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return numbers.size() != uniqueNumbers.size();
    }

    public boolean contains(int number) {
        return numbers.contains( number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
