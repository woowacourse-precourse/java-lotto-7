package lotto.validator;

public class BonusNumber {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public void validateBonusNumber(String bonusNumber) {
        validateEmptyString(bonusNumber);
        validateIntegerInput(bonusNumber);
        validateNumberRange(bonusNumber);
    }

    private void validateEmptyString(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "보너스 번호를 입력해주세요.");
        }
    }

    private void validateIntegerInput(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + "유효하지 않은 값이 포함되어 있습니다.");
        }
    }

    private void validateNumberRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_PREFIX + number + ": 1과 45사이의 숫자가 아닙니다.");
        }
    }
}
