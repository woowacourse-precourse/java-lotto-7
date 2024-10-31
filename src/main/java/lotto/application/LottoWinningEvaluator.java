package lotto.application;

import lotto.Lotto;
import lotto.LottoPrize;
import lotto.dto.WinningLotto;

import java.util.Optional;

public class LottoWinningEvaluator {

    /**
     * 로또 당첨 번호와 로또를 비교한다.
     * 당첨에 실패하면 Optional.empty()를 반환한다.
     */
    public Optional<LottoPrize> calculatePrize(Lotto lotto, WinningLotto winningLotto) {
        int matchLottoCount = (int) lotto.getNumbers().stream()
            .filter(winningLotto.lotto().getNumbers()::contains)
            .count();
        boolean matchBonus = lotto.getNumbers().contains(winningLotto.bonusNumber());

        return LottoPrize.findByMatch(matchLottoCount, matchBonus);
    }
}
