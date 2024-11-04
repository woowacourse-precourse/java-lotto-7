package lotto.util;

public class PurchaseValidator {
    public static void validatePurchaseAmount(int amount){
        if(amount%1000!=0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
