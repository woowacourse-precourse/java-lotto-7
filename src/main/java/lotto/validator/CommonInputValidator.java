package lotto.validator;

public class CommonInputValidator {

    public static void validateCommonInput(String input) {
        validateIsNotEmptyInput(input);
        validateHasNoWhiteSpace(input);
    }

    private static void validateIsNotEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 비어있습니다.");
        }
    }

    private static void validateHasNoWhiteSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 공백이 포함되어 있습니다.");
        }
    }
}
