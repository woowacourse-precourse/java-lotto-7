package lotto.validator;

public class BonusNumberInputValidator {

    public static final String NUMERIC_REGEX = "\\d+";
    public static final String ERROR_MESSAGE_INVALID_BONUS_NUMBER_FORMAT = "[ERROR] 로또 보너스 번호는 숫자로만 입력해야 합니다.";

    public static void validateBonusNumberInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        validateIsNumeric(input);
    }

    private static void validateIsNumeric(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_BONUS_NUMBER_FORMAT);
        }
    }

    private static boolean isNotNumeric(String input) {
        return !input.matches(NUMERIC_REGEX);
    }
}
