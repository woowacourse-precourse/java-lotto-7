package lotto.validator;

import lotto.enums.ExceptionMessage;
import lotto.enums.LottoValue;

public class AmountValidator implements Validator {
    @Override
    public void validate(String input) {
        validateNull(input);
        validateNumeric(input);
        validateNonZeroStart(input);
        validateUnit(input);
    }

    private void validateUnit(String input) {
        int price = Integer.parseInt(input);
        if (price % LottoValue.PRICE_PER_LOTTO.getValue() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
        }
    }

}
