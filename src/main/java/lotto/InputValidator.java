package lotto;

public class InputValidator {
    static void validatePurchaseAmount(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 양수가 아닙니다.");
        }

        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount % 1000 !=0) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 로또 가격으로 나누어지지 않습니다.");
        }
    }
}
