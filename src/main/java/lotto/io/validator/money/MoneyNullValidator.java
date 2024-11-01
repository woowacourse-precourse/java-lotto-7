package lotto.io.validator.money;

import static java.util.Objects.isNull;
import static lotto.io.exception.EmptyInputException.emptyPurchaseAmount;

import lotto.io.validator.InputValidator;

public class MoneyNullValidator extends InputValidator {

    private MoneyNullValidator() {
    }

    public static MoneyNullValidator initiate() {
        return new MoneyNullValidator();
    }

    @Override
    public void check(final String source) {
        if (isNull(source) || source.isEmpty() || source.isBlank()) {
            throw emptyPurchaseAmount();
        }
        String cleanedSource = source.strip();
        super.check(cleanedSource);
    }
}
