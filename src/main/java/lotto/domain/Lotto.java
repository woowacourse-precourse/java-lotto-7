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
            throw ErrorCode.INVALID_LOTTO_NUMBER.exception();
        }

        numbersDuplicateCheck(numbers);
        numbersRangeCheck(numbers);
    }

    private void numbersDuplicateCheck(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (numbers.size() > nonDuplicateNumbers.size()) {
            throw ErrorCode.DUPLICATE_LOTTO_NUMBER.exception();
        }
    }

    private void numbersRangeCheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0 || number > 45) {
                throw ErrorCode.INVALID_LOTTO_NUMBER.exception();
            }
        }
    }

}
