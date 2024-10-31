package lotto.domain.vo;

import java.util.List;

import lotto.domain.validator.CompositeValidator;
import lotto.domain.validator.InputValidator;
import lotto.domain.validator.NonBlankValidator;
import lotto.domain.validator.NumberFormatValidator;

public record PurchaseAmount(int amount) {
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
        return Integer.parseInt(input);
    }
}