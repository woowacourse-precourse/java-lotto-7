package lotto.errors;

public class PurchaseAmountErrors {

    public void errorCheck(String purchaseAmount) {
        validateNumericPurchaseAmount(purchaseAmount);
        Integer purchaseAmountInt = Integer.parseInt(purchaseAmount);
        validatePurchaseAmountInThousands(purchaseAmountInt);
        validateMinimumPurchaseAmount(purchaseAmountInt);
    }

    // 숫자 이외의 값을 입력했을 경우
    public void validateNumericPurchaseAmount(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    // 구입 금액이 1000원 단위가 아닌 경우
    public void validatePurchaseAmountInThousands(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    // 구입 금액이 1000원 미만일 경우
    public void validateMinimumPurchaseAmount(int amount) {
        if (amount < 0) {
            throw new IllegalStateException("[ERROR] 유효하지 않은 로또 구입 금액입니다.");
        }
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1000원입니다.");
        }

    }
}
