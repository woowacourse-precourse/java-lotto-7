package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    private static final String DELIMITER = ",";

    public final List<Integer> numbers;

    public WinningNumbers(String inputNumbers) {
        List<String> numbersInString = parse(inputNumbers);
        this.numbers = validateInteger(numbersInString);
        validateSixNumbers(numbers);
    }

    private List<String> parse(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(DELIMITER))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    private List<Integer> validateInteger(List<String> numbersInString) {
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String number : numbersInString) {
            try {
                parsedNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
        return parsedNumbers;
    }

    private void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new NumberFormatException();
        }
    }
}
