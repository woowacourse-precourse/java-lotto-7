package lotto.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PurchaseAmountValidator implements Validator {
    private static final int MIN_VALUE = 1000;
    private static final int MAX_VALUE = 100000;
    private static final String INCORRECT_TYPE = "소수점이 없는 양수를 입력해 주세요.";
    private static final String NOT_DIVISIBLE = "천 단위의 금액을 입력해 주세요.";
    private static final String NOT_WITHIN_RANGE = "구입금액은 1,000원 이상, 100,000원 이하여야 합니다.";

    @Override
    public void validate(String input) {
        checkInputType(input);
        checkDivisibility(input);
        checkValueRange(input);
    }

    private void checkInputType(String input) {
        Pattern inputPattern = Pattern.compile(POSITIVE_WHOLE_INT_REGEX);
        Matcher matcher = inputPattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(INCORRECT_TYPE);
        }
    }

    private void checkDivisibility(String input) {
        int amount = Integer.parseInt(input);
        if (amount % MIN_VALUE != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE);
        }
    }

    private void checkValueRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < MIN_VALUE || amount > MAX_VALUE) {
            throw new IllegalArgumentException(NOT_WITHIN_RANGE);
        }
    }
}
