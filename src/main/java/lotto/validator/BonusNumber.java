package lotto.validator;

import java.util.List;

public class BonusNumber {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        validateEmptyString(bonusNumber);
        int bonus = validateIntegerInput(bonusNumber);
        validateNumberRange(bonus);
        validateNumbersUnique(bonus, winningNumbers);
    }

    private void validateEmptyString(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "보너스 번호를 입력해주세요.");
        }
    }

    private int validateIntegerInput(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + "유효하지 않은 값이 포함되어 있습니다.");
        }
    }

    private void validateNumberRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(ERROR_PREFIX + bonus + ": 1과 45사이의 숫자가 아닙니다.");
        }
    }

    private void validateNumbersUnique(int bonus, List<Integer> winningNumbers) {
        if(winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_PREFIX + bonus + ": 당첨 번호와 중복되지 않는 숫자를 입력해주세요.");
        }
    }
}
