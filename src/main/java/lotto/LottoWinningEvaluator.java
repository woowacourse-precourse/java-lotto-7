package lotto;

public class LottoWinningEvaluator {

    public LottoPrize calculatePrize(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int matchLottoCount = (int) lotto.getNumbers().stream()
            .filter(winningLotto.getNumbers()::contains)
            .count();
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

        return LottoPrize.of(matchLottoCount, matchBonus);
    }
}
