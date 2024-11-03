package lotto.model.lotto;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumberWith(Lotto lotto) {
        int matchCount = 0;
        for (Integer number : lotto.numbers) {
            if (this.lotto.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusNumberMatchedWith(Lotto lotto) {
        return lotto.numbers.contains(bonusNumber);
    }
}
