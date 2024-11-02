package lotto;

import java.util.List;

public class BonusNumber {
    private final static String ERROR_BONUS_NUMBERS_RANGE = "[ERROR] 보너스 번호는 1에서 45 사이의 숫자만 가능합니다.";
    private final static String ERROR_INVALID_NUMBER = "[ERROR] 보너스 번호는 숫자만 가능합니다. ";
    private final static String ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBERS = "[ERROR] 당첨 번호와 보너스 번호는 중복되지 않아야합니다.";
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        validate(bonusNumber, winningNumbers);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber == null || bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBERS_RANGE);
        }
        try {
            int number = Integer.parseInt(bonusNumber);
            if (LOTTO_MIN_NUMBER > number || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_BONUS_NUMBERS_RANGE);
            } else if (isDuplicate(number, winningNumbers)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBERS);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER + '"' + bonusNumber + '"');
        }
    }

    private boolean isDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}