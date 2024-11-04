package lotto.model.lotto;

public class PurchaseAmount {

    private static final String INVALID_NUMERIC_MESSAGE = "[ERROR] 구입 금액은 숫자만 입력 가능합니다.";
    private static final String INVALID_MIN_AMOUNT_MESSAGE = "[ERROR] 구입 가능 최소 금액은 1,000원 입니다.";
    private static final String INVALID_EMPTY_MESSAGE = "[ERROR] 구입 금액이 빈 값입니다.";
    private static final String INVALID_AMOUNT_UNIT_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력 가능합니다.";

    private static final int MIN_AMOUNT = 1000;
    private static final int AMOUNT_UNIT = 1000;

    private final int amount;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount from(String input) {
        validateEmpty(input);
        validateNumeric(input);
        return new PurchaseAmount(Integer.parseInt(input));
    }

    private static void validateNumeric(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMERIC_MESSAGE);
        }
    }

    private static void validateEmpty(String amount) {
        if (amount == null || amount.isBlank()) {
            throw new IllegalArgumentException(INVALID_EMPTY_MESSAGE);
        }
    }

    private void validate(int amount) {
        validateMinAmount(amount);
        validateUnit(amount);
    }

    private void validateMinAmount(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(INVALID_MIN_AMOUNT_MESSAGE);
        }
    }

    private void validateUnit(int amount) {
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT_MESSAGE);
        }
    }

    public double calculateProfitPercentage(int totalPrizeMoney) {
        double profitPercentage = ((double) totalPrizeMoney / amount) * 100;
        return (double) Math.round(profitPercentage * 100) / 100.0;
    }

    public int calculatePurchasableLottoAmount() {
        return amount / AMOUNT_UNIT;
    }

}
