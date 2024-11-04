package lotto.domain;

import lotto.constant.Constant;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.util.Parser;
import lotto.validator.Validator;

public class Amount {
    private static final int MIN_PURCHASE_AMOUNT = 1000;

    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount of(String input) {
        validate(input);
        return new Amount(Integer.parseInt(input));
    }

    private static void validate(String input) {
        Validator.validateBlank(input, ErrorMessage.BLANK_PURCHASE_AMOUNT);
        Validator.validateNumeric(input, ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT);
        validateRange(input);
    }

    private static void validateRange(String input) {
        int amount = Parser.parseInt(input);
        validateNegativeNumber(amount);
        validateUnderMinAmount(amount);
        validateUnit(amount);
    }

    private static void validateNegativeNumber(int amount) {
        if (amount < 0) {
            throw new LottoException(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateUnderMinAmount(int amount) {
        if (amount < MIN_PURCHASE_AMOUNT) {
            throw new LottoException(ErrorMessage.UNDER_THOUSAND_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateUnit(int amount) {
        if (amount % Constant.AMOUNT_UNIT != 0) {
            throw new LottoException(ErrorMessage.NOT_THOUSAND_UNIT_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}
