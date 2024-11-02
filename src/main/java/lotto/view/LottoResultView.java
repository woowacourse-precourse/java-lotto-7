package lotto.view;

import java.util.EnumMap;
import java.util.Map.Entry;
import lotto.enums.LottoWinInfo;

public class LottoResultView {
    public void displayLottoWins(EnumMap<LottoWinInfo, Integer> lottoWinCount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Entry<LottoWinInfo, Integer> lottoWinInfo : lottoWinCount.entrySet()) {
            displayLottoWin(lottoWinInfo.getKey(), lottoWinInfo.getValue());
        }
    }

    private void displayLottoWin(LottoWinInfo lottoWinInfo, Integer count) {
        int numberMatchCount = lottoWinInfo.getNumberMatchCount();
        boolean hasBonusNumber = lottoWinInfo.hasBonusNumber();
        int prize = lottoWinInfo.getPrize();
        if (hasBonusNumber) {
            System.out.printf("%d개 일치, 보너스볼 일치 (%,d원) - %d개\n", numberMatchCount, prize, count);
            return;
        }
        System.out.printf("%d개 일치 (%,d원) - %d개\n", numberMatchCount, prize, count);
    }

    public void readProfit() {
    }
}
