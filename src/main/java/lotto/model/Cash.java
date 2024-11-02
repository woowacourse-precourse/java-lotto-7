package lotto.model;

public class Cash {
    private static final int CASH_UNIT = 1000;
    private final int amountInUnits;

    public Cash(String inputAmount) {
        this.amountInUnits = parseAmount(inputAmount);
        validateAmountInUnits();
    }

    private void validateAmountInUnits() {
        if (amountInUnits % CASH_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] " + CASH_UNIT + "원 단위만 입력 가능합니다.");
        }
    }

    private int parseAmount(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 숫자가 아닙니다.");
        }
    }
}
