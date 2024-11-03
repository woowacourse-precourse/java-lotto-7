package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.view.ErrorMessage;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Integer> numbers) {
        List<Number> parsedNumbers = parseIntToNumber(numbers);
        validate(parsedNumbers);
        parsedNumbers.sort(Comparator.naturalOrder());
        this.numbers = parsedNumbers;
    }

    public Numbers(String numbers) {
        List<Number> parsedNumbers = parseStringToNumber(numbers);
        validate(parsedNumbers);
        parsedNumbers.sort(Comparator.naturalOrder());
        this.numbers = parsedNumbers;
    }

    private void validate(List<Number> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Number> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException(ErrorMessage.notValidNumbersSize());
    }

    private void validateDuplicate(List<Number> numbers) {
        if (numbers.size() != numbers.stream().distinct().count())
            throw new IllegalArgumentException(ErrorMessage.duplicateNumber());
    }

    private List<Number> parseStringToNumber(String numbers) {
        return new ArrayList<>(Stream.of(numbers.split(","))
            .map(String::trim)
            .map(Number::new)
            .toList());
    }

    private List<Number> parseIntToNumber(List<Integer> numbers) {
        return new ArrayList<>(numbers.stream()
            .map(Number::new)
            .collect(Collectors.toList()));
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public boolean contains(Number targetNumber) {
        return numbers.stream().anyMatch(number -> number.value() == targetNumber.value());
    }

    public boolean contains(int targetNumber) {
        return numbers.stream().anyMatch(number -> number.value() == targetNumber);
    }

    @Override
    public String toString() {
        return numbers.stream()
            .map(number -> String.valueOf(number.value()))
            .toList()
            .toString();
    }
}
