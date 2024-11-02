package lotto.validator;

public class BonusNumberInputValidator {

    public static final String POSITIVE_NUMBER_REGEX = "\\d+";

    public static void validateBonusNumberInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        validateIsPositiveNumber(input);
    }

    private static void validateIsPositiveNumber(String input) {
        if (isNotPositiveNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 로또 보너스 번호는 숫자로만 입력해야 합니다.");
        }
    }

    private static boolean isNotPositiveNumber(String input) {
        return !input.matches(POSITIVE_NUMBER_REGEX);
    }
}
