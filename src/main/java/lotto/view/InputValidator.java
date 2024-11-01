package lotto.view;

public class InputValidator {

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
}
