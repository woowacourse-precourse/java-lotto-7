package lotto.domain;

import lotto.domain.validator.RangeValidator;

public class Draw {

    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    public Draw(Lotto winningNumbers, Integer bonusNumber, RangeValidator rangeValidator) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber, winningNumbers, rangeValidator);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(Lotto winningNumbers) {
        if (winningNumbers == null) {
            throw new IllegalArgumentException("당첨 번호는 null 일 수 없습니다.");
        }
    }

    private void validateBonusNumber(Integer bonusNumber, Lotto winningNumbers, RangeValidator rangeValidator) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException("보너스 번호는 null 일 수 없습니다.");
        }

        if (rangeValidator.outOfRange(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 1 ~ 45 사이의 숫자입니다.");
        }

        if (winningNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
