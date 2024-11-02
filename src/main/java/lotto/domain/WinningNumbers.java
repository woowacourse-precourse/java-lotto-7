package lotto.domain;

public class WinningNumbers {

    private final Numbers winnigNumbers;
    private final Number bonusNumber;

    public WinningNumbers(Numbers winnigNumbers, Number bonusNumber) {
        validateNotOverlapped(winnigNumbers, bonusNumber);

        this.winnigNumbers = winnigNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNotOverlapped(Numbers winnigNumbers, Number bonusNumber) {
        if (winnigNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 겹치면 안됩니다");
        }
    }
}
