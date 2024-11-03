package lotto.model;

public class Cash {
    private static final int CASH_UNIT = 1000;
    private final int totalAmount;

    public Cash(String inputAmount) {
        this.totalAmount = parseAmount(inputAmount);
        validateAmountInUnits();
    }

    public int getPurchasableLottoCount() {
        return totalAmount / CASH_UNIT;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    private void validateAmountInUnits() {
        if (totalAmount % CASH_UNIT != 0 || totalAmount <= 0) {
            throw new IllegalArgumentException(CASH_UNIT + "원 단위의 자연수만 입력 가능합니다.");
        }
    }

    private int parseAmount(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자가 아닙니다.");
        }
    }
}
