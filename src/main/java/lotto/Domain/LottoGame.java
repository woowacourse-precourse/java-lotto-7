package lotto.Domain;

import java.util.List;
import lotto.Enum.LottoPrizeRank;

public class LottoGame {
    private final List<Lotto> purchasedLottos;
    private final WinningLotto winningLotto;
    private final LottoResult lottoResult;

    private LottoGame(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
        this.purchasedLottos = LottoMachine.issue(purchaseAmount);
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        this.lottoResult = new LottoResult(purchaseAmount);
    }

    public static LottoGame start(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
        return new LottoGame(purchaseAmount, winningNumbers, bonusNumber);
    }

    public void drawLottery() {
        for (Lotto lotto : purchasedLottos) {
            LottoPrizeRank rank = winningLotto.match(lotto);
            lottoResult.addResult(rank);
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public int getWinningCount(LottoPrizeRank rank) {
        return lottoResult.getWinningCount(rank);
    }

    public double getProfitRate() {
        return lottoResult.calculateProfitRate();
    }
}