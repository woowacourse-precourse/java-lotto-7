package lotto.Domain;

import java.util.List;
import lotto.Enum.LottoPrizeRank;

public class LottoGame {
    private final List<Lotto> lottos;
    private LottoResult lottoResult;
    private final LottoProfitCalculator profitCalculator;
    private final int purchaseAmount;

    public LottoGame(int money) {
        this.purchaseAmount = money;
        this.lottos = LottoMachine.issue(money);
        this.lottoResult = new LottoResult();
        this.profitCalculator = new LottoProfitCalculator();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void checkResult(WinningLotto winningLotto) {
        lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            LottoPrizeRank rank = winningLotto.match(lotto);
            lottoResult.addResult(rank);
        }
    }

    public int getWinningCount(LottoPrizeRank rank) {
        return lottoResult.getCount(rank);
    }

    public double calculateProfitRate() {
        return profitCalculator.calculateProfitRate(lottoResult, purchaseAmount);
    }
}