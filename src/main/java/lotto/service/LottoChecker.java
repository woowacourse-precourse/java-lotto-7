package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.MatchResult;
import lotto.domain.WinningNumbers;

public class LottoChecker {
    private WinningNumbers winningNumbers;

    public void setWinningNumbers(Lotto winning, Integer bonus) {
        winningNumbers = new WinningNumbers(winning, bonus);
    }

    public MatchResult checkOneLotto(Lotto lotto) {
        return winningNumbers.match(lotto);
    }

    public List<MatchResult> checkLottos(List<Lotto> lottos) {
        List<MatchResult> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            results.add(checkOneLotto(lotto));
        }
        return results;
    }
}
