package lotto.model.lotto;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumberWith(Lotto lotto) {
        int matchCount = 0;
        for (Integer number : lotto.numbers) {
            if (this.winningNumbers.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusNumberMatchedWith(Lotto lotto) {
        return lotto.numbers.contains(bonusNumber);
    }
}
