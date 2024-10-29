package lotto;

import java.util.Optional;

public class LottoWinningEvaluator {

    public Optional<LottoPrize> calculatePrize(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int matchLottoCount = (int) lotto.getNumbers().stream()
            .filter(winningLotto.getNumbers()::contains)
            .count();
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

        return LottoPrize.findByMatch(matchLottoCount, matchBonus);
    }
}
