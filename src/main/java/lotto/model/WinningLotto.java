package lotto.model;

public class WinningLotto {
    private Lotto winningLotto;
    private Bonus bonusNumber;

    public WinningLotto(Lotto winningLotto, Bonus bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.hasNumber(bonusNumber.getBonusNumber());
    }

    public int countMatchingNumbers(Lotto lotto) {
        return winningLotto.countingMatchNumbers(lotto);
    }

    public LottoRank calculateRank(Lotto lotto) {
        int matchingCount = countMatchingNumbers(lotto);
        boolean hasBonus = isBonusMatch(lotto);
        return LottoRank.getRank(matchingCount, hasBonus);
    }
}
