package lotto.model;

public class LottoDraw {
    private static final String DUPLICATE_MESSAGE = "[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.";

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoDraw(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateDuplicate(winningNumbers, bonusNumber);
    }

    private void validateDuplicate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.isWinningNumber(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
