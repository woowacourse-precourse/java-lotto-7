package lotto.vo;

import lotto.util.Parser;
import lotto.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.ErrorMessage.NOT_NUMBER_OR_RANGE_EXCESS;

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
        Validator.checkElementCount(elements);
        Validator.checkNumberRange(elements);
        Validator.checkDuplicate(elements);
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
}
