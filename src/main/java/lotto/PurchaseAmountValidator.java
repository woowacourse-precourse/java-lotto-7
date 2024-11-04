package lotto;

public class PurchaseAmountValidator {
    private static final int UNIT = 1000;

    public static String validate(String purchaseAmount) {
        int amount;
        try {
            amount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] int 범위 숫자만 입력해 주세요.(원 단위)");
        }
        if (amount < UNIT) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000 이상입니다.");
        }
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위입니다.");
        }
        return purchaseAmount;
    }
}
