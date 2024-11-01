package lotto.view;

public class InputValidator {
    public static void validateInputGeneralValue(String inputValue) {
        if (inputValue == null
                || inputValue.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    public static void validateInputInteger(String inputInteger) {
        validateInputGeneralValue(inputInteger);
        if (!inputInteger.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }
        if (inputInteger.length() > 10) {
            throw new IllegalArgumentException("[ERROR] 10자리 이하의 금액을 입력해주세요.");
        }
    }
}
