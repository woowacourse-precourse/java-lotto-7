package lotto.domain.vo;

import static lotto.common.constant.LottoConstant.*;
import static lotto.common.constant.ErrorMessages.*;

import lotto.domain.validator.InputValidator;
import lotto.domain.validator.LottoValidator;

public record BonusNumber(int number) {
    private static final InputValidator validator = new LottoValidator();

    public BonusNumber {
        validateRange(number);
    }

    public BonusNumber(String input) {
        this(parseAndValidate(input));
    }

    private static int parseAndValidate(String input) {
        validator.validate(input);
        int number = parseInt(input);
        validateRange(number);
        return number;
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input.trim());
    }

    private static void validateRange(int number) {
        if (MIN_RANGE.getValue() > number || number > MAX_RANGE.getValue()) {
            throw new IllegalArgumentException(MUST_BE_IN_RANGE.toString());
        }
    }
}
