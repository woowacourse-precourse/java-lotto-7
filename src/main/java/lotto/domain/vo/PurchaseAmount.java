package lotto.domain.vo;

import static lotto.common.exception.ErrorMessages.ERROR_TAG;

import java.util.List;

import lotto.domain.validator.CompositeValidator;
import lotto.domain.validator.InputValidator;
import lotto.domain.validator.NonBlankValidator;
import lotto.domain.validator.NumberFormatValidator;

public record PurchaseAmount(int amount) {
    private static final String INVALID_UNIT = ERROR_TAG + "1,000원 단위로 구입 금액을 입력해주세요.";
    private static final InputValidator validator = new CompositeValidator(List.of(
        new NonBlankValidator(),
        new NumberFormatValidator()
    ));

    public PurchaseAmount(String input) {
        this(parseAndValidate(input));
    }

    public static PurchaseAmount from(String input) {
        return new PurchaseAmount(input);
    }

    private static int parseAndValidate(String input) {
        validator.validate(input);
        return parseAmount(input);
    }

    private static int parseAmount(String input) {
        int amount = Integer.parseInt(input.trim());
        validateUnit(amount);
        return amount;
    }

    private static void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_UNIT);
        }
    }
}