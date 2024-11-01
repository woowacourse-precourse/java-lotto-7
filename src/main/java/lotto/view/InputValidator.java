package lotto.view;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class InputValidator {

    public static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]+$");

    public void validatePurchaseAmount(String purchaseAmount) {
        long amount;
        try {
            amount = Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아니거나, long의 범위를 벗어났습니다.", e);
        }

        validateThousandUnit(amount);
    }

    private static void validateThousandUnit(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1,000원 단위로 입력해야 합니다.");
        }
    }

    public void validateWinningNumber(String[] winningNumber) {
        Stream.of(winningNumber).forEach(this::validateStringNumber);
    }

    private void validateStringNumber(String stringNumber) {
        if (!NUMERIC_PATTERN.matcher(stringNumber).matches()) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }
}
