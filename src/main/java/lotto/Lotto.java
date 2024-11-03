package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        sizeCheck(numbers);
        duplicatedCheck(numbers);
        rangeCheck(numbers);
    }

    private void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE_LOTTO.format());
        }
    }

    private void duplicatedCheck(List<Integer> numbers) {
        Set<Integer> removeDuplicated = new HashSet<>(numbers);
        if (removeDuplicated.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.format());
        }
    }

    private void rangeCheck(List<Integer> numbers) {
        boolean outOfRange = numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
        if (outOfRange) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.format(1, 45));
        }
    }

    @Override
    public String toString() {
        return "["
                + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
