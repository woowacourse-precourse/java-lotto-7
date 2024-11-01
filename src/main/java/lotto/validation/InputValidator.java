package lotto.validation;

public class InputValidator {

    public static void purchaseAmountValidate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위입니다.");
        }
    }

//    public static void winningNumbersValiate()
}
