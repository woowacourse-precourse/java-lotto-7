package lotto.model;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchNumbersCount(Lotto userLotto) {
        return lotto.matchCount(userLotto);
    }

    public boolean matchBonusNumber(Lotto userLotto) {
        return userLotto.contains(bonusNumber);
    }
}