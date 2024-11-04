package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.util.Converter;
import lotto.util.Splitter;
import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(String input) {
        validate(input);
        List<String> tokens = Splitter.splitWithComma(input);
        return new Lotto(Converter.convertToNumbers(tokens));
    }

    private static void validate(String input) {
        Validator.validateBlank(input, ErrorMessage.BLANK_WINNING_NUMBER);
        List<String> tokens = Splitter.splitWithComma(input);
        tokens.forEach(token -> Validator.validateNumeric(token, ErrorMessage.NOT_NUMERIC_LOTTO_NUMBER));
    }

    private void validateNumbers(List<Integer> numbers) {
        Validator.validateNumbersSize(numbers);
        Validator.validateRange(numbers);
        Validator.validateDuplicate(numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
