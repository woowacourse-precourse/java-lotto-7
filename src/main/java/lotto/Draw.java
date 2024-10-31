package lotto;

public class Draw {

    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    public Draw(Lotto winningNumbers, Integer bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(Lotto winningNumbers) {
        if (winningNumbers == null) {
            throw new IllegalArgumentException("당첨 번호는 null 일 수 없습니다.");
        }
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException("보너스 번호는 null 일 수 없습니다.");
        }
    }

}
