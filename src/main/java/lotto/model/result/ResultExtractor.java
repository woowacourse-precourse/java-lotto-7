package lotto.model.result;

import java.util.Map;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.WinningLotto;

public class ResultExtractor {
    private final WinningLotto winningLotto;
    private final Lottos lottos;
    private final LottoResult lottoResult;

    public ResultExtractor(final WinningLotto winningLotto, final Lottos lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
        this.lottoResult = new LottoResult();
    }

    public Map<Rank, Integer> extract() {
        for (final Lotto lotto : lottos.getLottos()) {
            int countOfMatch = winningLotto.calculateMatchCount(lotto);
            boolean shotBonus = winningLotto.isBonusMatch(lotto);
            final Rank rank = Rank.extractRanking(countOfMatch, shotBonus);
            lottoResult.addResult(rank);
        }
        return lottoResult.getResult();
    }

    public double calculateProfitRate(final int originalMoney) {
        final long winningMoney = lottoResult.calculateWinningMoney();
        return ((double) winningMoney / originalMoney) * 100;
    }
}
