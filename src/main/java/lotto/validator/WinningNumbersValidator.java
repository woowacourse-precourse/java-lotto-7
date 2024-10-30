package lotto.validator;

import lotto.exception.WinningNumbers.BlankWinningNumbersException;
import lotto.exception.WinningNumbers.InvalidRangeException;
import lotto.exception.WinningNumbers.InvalidRuleException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {

    private static final String REGEX_INPUT_RULE = ".*[^,\\d\\s].*";
    private static final String DELIMITER = ",";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validate(final String input) {
        validateBlank(input);
        validateDelimiter(input);
        List<Integer> numbers = convert(input);
        validateNumberRange(numbers);
    }

    private static void validateBlank(final String input) {
        if(input.isBlank()) {
            throw new BlankWinningNumbersException();
        }
    }

    private static void validateDelimiter(final String input) {
        if(input.matches(REGEX_INPUT_RULE)) {
            throw new InvalidRuleException();
        }
    }

    private static void validateNumberRange(final List<Integer> numbers) {
        for(int number: numbers) {
            checkRange(number);
        }
    }

    private static void checkRange(final int number) {
        if(!(number >= MIN_NUMBER && number <= MAX_NUMBER)) {
            throw new InvalidRangeException();
        }
    }

    private static List<Integer> convert(final String input) {
        return Arrays.stream(input.split(DELIMITER)).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}
