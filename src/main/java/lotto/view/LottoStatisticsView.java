package lotto.view;

import java.text.NumberFormat;
import java.util.Map;
import lotto.model.constant.LottoRank;

public class LottoStatisticsView {

    public void announce(Map<LottoRank, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + NumberFormat.getInstance().format(LottoRank.FIFTH.getWinningPrize()) + "원) - " + statistics.getOrDefault(LottoRank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (" + NumberFormat.getInstance().format(LottoRank.FOURTH.getWinningPrize()) + "원) - " + statistics.getOrDefault(LottoRank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (" + NumberFormat.getInstance().format(LottoRank.THIRD.getWinningPrize()) + "원) - " + statistics.getOrDefault(LottoRank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + NumberFormat.getInstance().format(LottoRank.SECOND.getWinningPrize()) + "원) - " + statistics.getOrDefault(LottoRank.SECOND, 0) + "개");
        System.out.println("6개 일치 (" + NumberFormat.getInstance().format(LottoRank.FIRST.getWinningPrize()) + "원) - " + statistics.getOrDefault(LottoRank.FIRST, 0) + "개");
    }
}
