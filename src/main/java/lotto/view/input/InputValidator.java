package lotto.view.input;

public class InputValidator {
    public static void validateGeneralValueInput(String generalValue) {
        if (generalValue == null
                || generalValue.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    public static void validateInputInteger(String integerInput) {
        validateGeneralValueInput(integerInput);
        if (!integerInput.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }
        if (integerInput.length() > 10) {
            throw new IllegalArgumentException("[ERROR] 10자리 이하의 금액을 입력해주세요.");
        }
    }
}
