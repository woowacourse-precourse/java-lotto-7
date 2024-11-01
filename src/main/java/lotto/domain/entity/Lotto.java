package lotto.domain.entity;

import static lotto.common.exception.ErrorMessages.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.common.util.RandomsWrapper;

public class Lotto {
    private static final int LENGTH = 6;
    private static final String INCORRECT_LENGTH = ERROR_TAG + String.format("로또 번호는 %d개여야 합니다.", LENGTH);
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto createAutoNumbers() {
        return new Lotto(generateNumbers());
    }

    private static List<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < LENGTH) {
            numbers.add(generateRandomNumber());
        }
        return new ArrayList<>(numbers);
    }

    private static Integer generateRandomNumber() {
        return RandomsWrapper.getInt();
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LENGTH) {
            throw new IllegalArgumentException(INCORRECT_LENGTH);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int size = (int)numbers.stream().distinct().count();
        if (size != LENGTH) {
            throw new IllegalArgumentException(String.valueOf(DUPLICATED));
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
