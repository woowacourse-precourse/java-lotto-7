package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoWinningResult;

import java.util.List;

public class LottoResultPrinter {

    private LottoResultManager lottoResultManager = new LottoResultManager();

    public void printResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        int[] saveResult = lottoResultManager.saveLottoWinningResult(lottos, winningLotto, bonusNumber);
        System.out.println(LottoWinningResult.THREE_MATCHES.print(saveResult[0]));
        System.out.println(LottoWinningResult.FOUR_MATCHES.print(saveResult[1]));
        System.out.println(LottoWinningResult.FIVE_MATCHES.print(saveResult[2]));
        System.out.println(LottoWinningResult.FIVE_AND_BONUS_MATCHES.print(saveResult[3]));
        System.out.println(LottoWinningResult.SIX_MATCHES.print(saveResult[4]));
    }

    public void printProfitRate(List<Lotto> lottos, Lotto winningLotto, int bonusNumber, int purchaseAmount) {
        int[] saveResult = lottoResultManager.saveLottoWinningResult(lottos, winningLotto, bonusNumber);
        int profit = 0;
        profit += saveResult[0] * LottoWinningResult.THREE_MATCHES.getAmount();
        profit += saveResult[1] * LottoWinningResult.FOUR_MATCHES.getAmount();
        profit += saveResult[2] * LottoWinningResult.FIVE_MATCHES.getAmount();
        profit += saveResult[3] * LottoWinningResult.FIVE_AND_BONUS_MATCHES.getAmount();
        profit += saveResult[4] * LottoWinningResult.SIX_MATCHES.getAmount();

        double profitRate = (double) profit / purchaseAmount *100;
        System.out.println("총 수익률은 " + Math.round(profitRate*10)/10.0 + "%입니다.");
    }
}
