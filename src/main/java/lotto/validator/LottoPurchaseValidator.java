package lotto.validator;

public class LottoPurchaseValidator {
    public static void validatePurchase(int lottoAmount) {
        validateAmount(lottoAmount);
    }
    public static void validatePurchaseStringInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어있을 수 없습니다.");
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }
    public static void validateAmount(int lottoAmount) {
        if (lottoAmount > 1000000000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 너무 큽니다. 다시 입력해 주세요.");
        }
        if (lottoAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1원 이상의 양수로 입력해야 합니다.");
        }
        if (lottoAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
