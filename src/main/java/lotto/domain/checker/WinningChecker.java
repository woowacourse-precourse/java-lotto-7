package lotto.domain.checker;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

public class WinningChecker {
    private final Lottos lottos;
    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningChecker(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto.getNumbers();
        this.bonusNumber = winningLotto.getBonusNumber();
    }

    public Result checkWinning() {
        Result results = Result.from();
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers();

            long count = lottoNumbers.stream()
                    .filter(winningLotto::contains)
                    .count();

            boolean hasBonusNumber = checkBonusNumber(lottoNumbers);
            results.updateResults((int) count, hasBonusNumber);
        }
        return results;
    }

    private boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
