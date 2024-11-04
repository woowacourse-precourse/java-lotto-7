package lotto.support.converter;

import java.math.BigDecimal;
import java.util.List;
import lotto.exception.argument.converter.InvalidConvertException;
import lotto.support.validator.InputValidator;

public class Converter {

    public List<Integer> convertToInteger(List<String> numbers) {
        InputValidator.validateNotNullOrEmpty(numbers, "숫자 목록");
        return numbers.stream()
                .map(this::convertToInteger)
                .toList();
    }

    public int convertToInteger(final String input) {
        InputValidator.validateNotNullOrBlank(input, "숫자");
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException exception) {
            throw new InvalidConvertException("유효한 정수형식이어야 합니다.");
        }
    }

    public BigDecimal convertToBigDecimal(final String input) {
        InputValidator.validateNotNullOrBlank(input, "실수");
        try {
            return new BigDecimal(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidConvertException("유효한 실수형식이어야 합니다.");
        }
    }
}
