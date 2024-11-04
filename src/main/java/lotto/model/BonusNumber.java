package lotto.model;

import static lotto.model.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.model.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.model.LottoErrorConstants.INVALID_NUMBER_RANGE_ERROR_MESSAGE;

import java.util.List;

public class BonusNumber {

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
