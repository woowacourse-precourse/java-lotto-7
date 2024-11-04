package lotto.controller;

public class InputValidator {
    private static final int INPUT_AMOUNT_UNIT = 1000;
    private static final int MAX_INPUT_AMOUNT = 2100000000;

    public void validatePurchaseAmount(String purchaseAmount) {
        long amount = parseAmount(purchaseAmount.trim());
        validateThousandUnit(amount);
        validateMaxAmount(amount);
    }

    private long parseAmount(String purchaseAmount) {
        try {
            return Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아니거나, long의 범위를 벗어났습니다.", e);
        }
    }

    private void validateThousandUnit(long amount) {
        if (amount < INPUT_AMOUNT_UNIT || amount % INPUT_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(String.format("%d원 단위로 입력해야 합니다.", INPUT_AMOUNT_UNIT));
        }
    }

    private void validateMaxAmount(long amount) {
        if (amount > MAX_INPUT_AMOUNT) {
            throw new IllegalArgumentException(String.format("최대 %d까지 입력가능합니다.", MAX_INPUT_AMOUNT));
        }
    }
}
