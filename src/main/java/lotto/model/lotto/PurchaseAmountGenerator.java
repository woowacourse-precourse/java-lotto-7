package lotto.model.lotto;

public class PurchaseAmountGenerator {
    public static PurchaseAmount registerPurchaseAmount(String purchaseAmount) {
        try {
            return new PurchaseAmount(Integer.parseInt(purchaseAmount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }
    }
}
