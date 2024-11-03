package lotto;

import java.util.List;

public class BonusNumber {

    private static final String INVALID_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int bonusNumber;

    public BonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {
        this.bonusNumber = parseBonusNumber(bonusNumberInput);
        validateBonusNumber(this.bonusNumber, winningNumbers);
    }

    private int parseBonusNumber(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_ERROR);
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_ERROR);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR);
        }
    }

    public int get() {
        return bonusNumber;
    }
}
