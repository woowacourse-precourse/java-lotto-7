package lotto.view.winningLottoView;

import lotto.model.lotto.LottoRankAward;
import lotto.util.NumberFormatter;

import java.util.Map;

public class WinningLottoOutputView {

    private final NumberFormatter numberFormatter;

    public WinningLottoOutputView(NumberFormatter numberFormatter) {
        this.numberFormatter = numberFormatter;
    }

    public void showLottoResult(Map<LottoRankAward, Integer> lottoResult){
        System.out.println("당첨 통계\n---");

        for (Map.Entry<LottoRankAward, Integer> entry : lottoResult.entrySet()) {
            LottoRankAward rank = entry.getKey();
            String message = createLottoResultMessage(rank, entry.getValue());
            System.out.println(message);
        }
    }

    private String createLottoResultMessage(LottoRankAward rank, int count){
        String bonusNumberMatchedMessage = getBonusNumberMatchedMessage(rank.getIsBonusMatched());
        return String.format("%d개 일치%s (%s원) - %d개",
                rank.getMatchLottoNumberCount(),
                bonusNumberMatchedMessage,
                numberFormatter.formatNumber(rank.getWinningMoneyPrize()),
                count);
    }

    private String getBonusNumberMatchedMessage(boolean isBonusMatched){
        String bonusNumberMatchedMessage = "";
        if (isBonusMatched){
            bonusNumberMatchedMessage = ", 보너스 볼 일치";
        }
        return bonusNumberMatchedMessage;
    }



}
