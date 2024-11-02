package lotto.domain;

import lotto.util.ErrorCode;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = sortNumbers();

        List<String> formattedNumbers = sortedNumbers.stream()
                .map(String::valueOf)
                .toList();

        return "[" + String.join(", ", formattedNumbers) + "]";
    }

    private List<Integer> sortNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw ErrorCode.INVALID_LOTTO_NUMBER_COUNT.exception();
        }

        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (numbers.size() > nonDuplicateNumbers.size()) {
            throw ErrorCode.DUPLICATE_LOTTO_NUMBER.exception();
        }
    }

}
