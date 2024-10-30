package lotto.view;

public class InputHandler {

    public static void validatePurchaseAmount(int purchaseAmount){
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
