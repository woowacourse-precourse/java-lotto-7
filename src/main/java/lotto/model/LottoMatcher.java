package lotto.model;

public class LottoMatcher {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoMatcher(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank determineRank(Lotto lotto) {
        int matchCount = lotto.countMatches(winningLotto);
        boolean validateBonusNumber = lotto.isBonusMatched(bonusNumber);
        return LottoRank.getRank(matchCount, validateBonusNumber);
    }
}
