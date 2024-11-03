package lotto.errors;

public class PurchaseAmountErrors {

    public void errorCheck(String purchaseAmount) {
        Integer purchaseAmountInt = Integer.parseInt(purchaseAmount);
        validatePurchaseAmountInThousands(purchaseAmountInt);
        validateMinimumPurchaseAmount(purchaseAmountInt);
        validateNumericPurchaseAmount(purchaseAmount);
    }

    // 구입 금액이 1000원 단위가 아닌 경우
    public void validatePurchaseAmountInThousands(int amount){

    }

    // 구입 금액이 1000원 미만일 경우
    public void validateMinimumPurchaseAmount(int amount) {

    }

    // 숫자 이외의 값을 입력했을 경우
    public void validateNumericPurchaseAmount(String input) {

    }

}
