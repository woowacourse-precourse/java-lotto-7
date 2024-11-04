package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.util.Parser;
import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(String input) {
        validate(input);
        List<String> numbers = Parser.parseStringList(input);
        return new Lotto(Parser.parseIntegerList(numbers));
    }

    private static void validate(String input) {
        Validator.validateBlank(input, ErrorMessage.BLANK_WINNING_NUMBER);
        List<String> numbers = Parser.parseStringList(input);
        numbers.forEach(number ->
                Validator.validateNumeric(number, ErrorMessage.NOT_NUMERIC_LOTTO_NUMBER)
        );
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_COUNT) {
            throw new LottoException(ErrorMessage.NOT_LOTTO_NUMBER_COUNT_SIX.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(number ->
                Validator.validateNumberRange(number, ErrorMessage.OUT_RANGE_LOTTO_NUMBER)
        );
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new LottoException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
