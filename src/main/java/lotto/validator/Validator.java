package lotto.validator;

public class Validator {
    private static final String ERROR_INVALID_NUMERIC = "[ERROR] 로또 번호는 숫자 형식이어야 합니다.";
    private static final String ERROR_INVALID_AMOUNT_UNIT = "[ERROR] 금액은 1,000원 단위입니다.";
    private static final String ERROR_INVALID_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";


    public static void validateLottoAmount(String inputAmount) {
        validateNumeric(inputAmount);
        validateAmountUnit(inputAmount);
    }

    public static void validateBonusNumber(String inputBonus) {
        validateNumeric(inputBonus);
        validateLottoNumberRange(inputBonus);
    }

    public static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMERIC);
        }
    }

    public static void validateAmountUnit(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT_UNIT);
        }
    }

    public static void validateLottoNumberRange(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_RANGE);
        }
    }
}
