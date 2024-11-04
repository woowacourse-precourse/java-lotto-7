package lotto.model;

import java.util.List;

public class BonusNumber {
    private static final String NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATED_BONUS_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 로또 번호와 중복되는 보너스 번호는 입력할 수 없습니다.";

    private Integer bonusNumber;

    public BonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
