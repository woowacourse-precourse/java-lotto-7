package lotto.model;

public class LottoRankEvaluator {

    private final WinningLotto winningLotto;

    public LottoRankEvaluator(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Rank evaluateRank(Lotto lotto) {
        long matchCount = countMatchingNumbers(lotto);
        boolean hasBonus = containsBonusNumber(lotto);
        return Rank.of(matchCount, hasBonus);
    }

    private long countMatchingNumbers(Lotto lotto) {
        return winningLotto
                .getLotto()
                .getNumbers()
                .stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    private boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber().getLottoNumber());
    }
}
