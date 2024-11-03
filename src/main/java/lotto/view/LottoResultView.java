package lotto.view;

import java.util.EnumMap;
import java.util.Map.Entry;
import lotto.constant.LottoWinInfo;

public class LottoResultView {
    public void displayLottoWins(final EnumMap<LottoWinInfo, Integer> lottoWinCount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Entry<LottoWinInfo, Integer> lottoWinInfo : lottoWinCount.entrySet()) {
            displayLottoWin(lottoWinInfo.getKey(), lottoWinInfo.getValue());
        }
    }

    private void displayLottoWin(final LottoWinInfo lottoWinInfo, final Integer count) {
        int numberMatchCount = lottoWinInfo.getNumberMatchCount();
        boolean hasBonusNumber = lottoWinInfo.hasBonusNumber();
        int prize = lottoWinInfo.getPrize();
        if (hasBonusNumber) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", numberMatchCount, prize, count);
            return;
        }
        System.out.printf("%d개 일치 (%,d원) - %d개\n", numberMatchCount, prize, count);
    }

    public void displayProfit(final double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}
