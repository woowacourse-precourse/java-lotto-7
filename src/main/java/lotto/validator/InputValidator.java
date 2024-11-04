package lotto.validator;

public class InputValidator {


    public void validatePayMoney(String input) {
        validateNotEmpty(input);
        validateInteger(input);
        validatePurchaseAmount(input);
    }

    private void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 null이거나 빈 문자열입니다.");
        }
    }

    private void validatePurchaseAmount(String input) {
        int amount = Integer.parseInt(input);

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 유효한 정수가 아닙니다.");
        }
    }
}
