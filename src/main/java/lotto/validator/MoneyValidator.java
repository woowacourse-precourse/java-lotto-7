package lotto.validator;

public class MoneyValidator {
    public static void validateInputMoney(String inputMoney) {
        if (inputMoney == null) {
            throw new IllegalArgumentException("[ERROR] 돈을 입력해야 합니다.");
        }
    }

    public static void validateMoney(int money) {
        if (money<0) {
            throw new IllegalArgumentException("[ERROR] 돈은 0보다 커야 합니다.");
        }
    }

    public static void validatePurchaseAmount(int money) {
        if (money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원단위로 입력하셔야 합니다.");
        }
    }

}
