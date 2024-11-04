package lotto.utils;

public class InputValidator {

    public static void validateNonEmptyAmount(String money) {
        if (money.isEmpty()) {
            throw new IllegalArgumentException("금액을 입력해 주세요.");
        }
    }

    public static void validateNumericAmount(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액은 숫자만 입력할 수 있습니다.");
        }
    }
}
