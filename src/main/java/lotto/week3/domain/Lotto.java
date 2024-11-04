package lotto.week3.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.week3.global.error.message.ErrorMessage;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = List.copyOf(numbers);
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_CANNOT_BE_NULL.getMessage());
        }
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_CANNOT_BE_EMPTY.getMessage());
        }
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_MUST_BE_SIX.getMessage());
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_MUST_NOT_BE_DUPLICATED.getMessage());
        }
        if (!areNumbersInRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45.getMessage());
        }
    }

    private Boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }

    private boolean areNumbersInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= MIN_NUMBER && num <= MAX_NUMBER);
    }


    // TODO: 추가 기능 구현
    public int matchCount(List<Integer> winningNumber) {
        return (int) numbers.stream().filter(winningNumber::contains).count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
