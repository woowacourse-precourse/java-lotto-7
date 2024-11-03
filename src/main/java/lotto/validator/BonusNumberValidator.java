package lotto.validator;

import java.util.List;

public class BonusNumberValidator implements Validator {
    private static final String BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String BONUS_NUMBER_DUPLICATED = "[ERROR] 보너스 번호가 중복되었습니다.";
    private static final int minNumber = 1;
    private static final int maxNumber = 45;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public BonusNumberValidator(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = List.copyOf(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    @Override
    public void validate() throws IllegalArgumentException {
        validateBonusNumberInRange();
        validateBonusNumberDuplication();
    }

    private void validateBonusNumberInRange() throws IllegalArgumentException {
        if (bonusNumber < minNumber || bonusNumber > maxNumber) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateBonusNumberDuplication() throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED);
        }
    }

}
