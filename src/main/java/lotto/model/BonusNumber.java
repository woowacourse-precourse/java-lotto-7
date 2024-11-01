package lotto.model;

import java.util.List;

public class BonusNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String INVALID_NUMBER_RANGE_ERROR_MESSAGE =
            "로또 숫자는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + " 이하입니다.";
    private static final String DUPLICATE_WITH_WINNING_NUMBER_ERROR_MESSAGE = "보너스 번호는 당첨 번호에 없는 번호이어야합니다.";

    int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumber) {
        validate(bonusNumber, winningNumber);
        this.bonusNumber = bonusNumber;

    }

    private void validate(int bonusNumber, List<Integer> winningNumber) {
        valiateNumberRange(bonusNumber);
        validateDuplicateWinningNumber(bonusNumber, winningNumber);
    }


    private void valiateNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public void validateDuplicateWinningNumber(int bonusNumber, List<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WITH_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean checkBonusNumber(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
