package lotto;

public final class InputConverter {

    private InputConverter() {
    }

    public static int convertToPurchaseAmount(final String purchaseAmountInput) {
        try {
            return Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다. 다시 입력해주세요.");
        }
    }
}
