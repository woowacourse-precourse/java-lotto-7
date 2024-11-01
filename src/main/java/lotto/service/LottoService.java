package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.MatchingResult;
import lotto.model.Rank;
import lotto.model.WinningLotto;

public class LottoService {

    public List<Lotto> buyLottos(Budget budget) {
        int quantities = budget.calculateNumberOfLotto();
        return IntStream.range(0, quantities)
                .mapToObj(i -> Lotto.createWithRandomNumbers())
                .toList();
    }

    public MatchingResult calculateMatchingResult(WinningLotto winningLotto, List<Lotto> lottos) {
        MatchingResult matchingResult = new MatchingResult(lottos.size());
        for (Lotto lotto : lottos) {
            try {
                Rank rank = Rank.findRank(winningLotto, lotto);
                matchingResult.incrementsSingleMatchCount(rank);
            } catch (IllegalStateException ignored) {
            }
        }
        return matchingResult;
    }

}
