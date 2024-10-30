package lotto.model;

import lotto.utils.Constants;

import static lotto.utils.StringValidator.validateOnlyDigits;
import static lotto.utils.StringValidator.validateEmpty;
import static lotto.utils.StringValidator.validateHasBlank;

public class SpendingMoney {
    
    private static final String EXCEPTION_MESSAGE_OUT_OF_LONG = "2의 63 제곱보다 작은 값을 입력하세요.";
    
    private static final String EXCEPTION_MESSAGE_MOD_THOUSAND_NOT_ZERO =
            "구매 금액은 1,000원으로 나누어 떨어져야 합니다.";
    
    private final long money;
    
    public SpendingMoney(String numberToValidate) {
        validateEmpty(numberToValidate);
        validateHasBlank(numberToValidate);
        validateOnlyDigits(numberToValidate);
        validateLongRange(numberToValidate);
        validateModThousand(numberToValidate);
        this.money = Long.parseLong(numberToValidate);
    }
    
    private void validateLongRange(String numberToValidate) {
        try {
            Long.parseLong(numberToValidate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.EXCEPTION_MESSAGE_PREFIX +
                    EXCEPTION_MESSAGE_OUT_OF_LONG);
        }
    }
    
    private void validateModThousand(String numberToValidate) {
        long number = Long.parseLong(numberToValidate);
        if (number % 1_000L != 0L) {
            throw new IllegalArgumentException(Constants.EXCEPTION_MESSAGE_PREFIX +
                    EXCEPTION_MESSAGE_MOD_THOUSAND_NOT_ZERO);
        }
    }
    
    public long get() {
        return money;
    }
    
}
