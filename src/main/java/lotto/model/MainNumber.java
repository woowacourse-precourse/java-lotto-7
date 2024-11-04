package lotto.model;

import lotto.util.Parser;
import lotto.util.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.common.ErrorMessage.*;
import static lotto.common.Constants.*;

public class MainNumber {

    private final List<Integer> numbers;

    public MainNumber(final String inputValue) {
        List<String> elements = separate(inputValue);
        List<Integer> numbers = convertType(elements);
        validate(numbers);
        this.numbers = numbers;
    }

    private List<String> separate(String inputValue) {
        return Parser.parseElements(inputValue);
    }

    private void validate(List<Integer> elements) {
        checkElementCount(elements);
        checkWinningNumberRange(elements);
        checkDuplicate(elements);
    }

    private List<Integer> convertType(List<String> elements) throws IllegalArgumentException {
        try {
            return elements.stream()
                    .map(Parser::parseStringToInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_OR_RANGE_EXCESS.getMessage());
        }
    }

    private void checkElementCount(List<Integer> numbers) {
        if (numbers.size() != MAIN_NUMBER_SIZE) {
            throw new IllegalArgumentException(MAIN_NUMBERS_COUNT.getMessage());
        }
    }

    private void checkWinningNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < RANGE_START || RANGE_END < number) {
                throw new IllegalArgumentException(WINNING_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> singleNumbers = new HashSet<>(numbers);
        if (numbers.size() != singleNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXIST.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
