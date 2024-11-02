package lotto.model.lotto;

public class PurchaseAmount {

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
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력 가능합니다.");
        }
    }

    private static void validateEmpty(String amount) {
        if (amount == null || amount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 빈 값입니다.");
        }
    }

    private void validate(int amount) {
        validateMinAmount(amount);
        validateUnit(amount);
    }

    private void validateMinAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 가능 최소 금액은 1,000원 입니다.");
        }
    }

    private void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 가능합니다.");
        }
    }

    public int getPurchasableLottoAmount() {
        return amount/1000;
    }

}
