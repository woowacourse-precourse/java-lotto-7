package lotto.domain;

import static lotto.common.ErrorMessage.ERROR_MESSAGE;

public class BonusNumber extends NumberImpl {

    final int bonusNumber;

    public BonusNumber(String rawBonusNumber, WinningNumbers winningNumbers) {
        String trimBonusNumber = rawBonusNumber.trim();
        validateBlank(trimBonusNumber, getDomain());
        validateNumber(trimBonusNumber, getDomain());
        Integer bonusNumber = Integer.parseInt(trimBonusNumber);
        validateDuplicate(winningNumbers, bonusNumber);
        validateRange(bonusNumber, getDomain());
        this.bonusNumber = Integer.parseInt(trimBonusNumber);
    }

    private void validateDuplicate(WinningNumbers winningNumbers, Integer bonusNumber) {
        winningNumbers.stream()
                .forEach(winningNumber -> {
                    isSame(winningNumber, bonusNumber);
                });
    }

    private void isSame(Integer winningNumber, Integer bonusNumber) {
        if (winningNumber.equals(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " " + getDomain() + "는 중복될 수 없습니다.");
        }
    }

    public Integer value() {
        return bonusNumber;
    }

    @Override
    public String getDomain() {
        return "보너스번호";
    }
}
