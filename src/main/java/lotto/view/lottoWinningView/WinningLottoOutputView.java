package lotto.view.lottoWinningView;

import lotto.model.lotto.LottoRankAward;
import lotto.util.NumberFormatter;

import java.util.Map;

public class WinningLottoOutputView {

    NumberFormatter numberFormatter = new NumberFormatter();


    public void showLottoResult(Map<LottoRankAward, Integer> lottoResult){
        String bonusNumberMatchedMessage = "";

        System.out.println("당첨 통계\n---");

        for (Map.Entry<LottoRankAward, Integer> entry : lottoResult.entrySet()) {
            LottoRankAward rank = entry.getKey();
            if (rank.getIsBonusMatched()){
                bonusNumberMatchedMessage = ", 보너스 볼 일치";
            }
            System.out.println(rank.getMatchLottoNumberCount() + "개 일치" + bonusNumberMatchedMessage +
                    " (" +
                    numberFormatter.formatNumber(rank.getWinningMoneyPrize())+ "원) - " +
                    entry.getValue() + "개"
            );
        }
    }

    public void showLottoProfitRate(double profitRate){
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
