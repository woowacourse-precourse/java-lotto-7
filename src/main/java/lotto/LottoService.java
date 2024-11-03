package lotto;

import java.util.List;

public class LottoService {
    public LottoStatistics calculateStatistics(List<Lotto> lottos, List<Integer> winNumbers, Integer bonusNumber) {
        LottoStatistics statistics = new LottoStatistics();
        for (Lotto lotto : lottos) {
            LottoResult result = lotto.checkWinning(winNumbers, bonusNumber);
            statistics.recordWin(result);
        }
        return statistics;
    }
}
