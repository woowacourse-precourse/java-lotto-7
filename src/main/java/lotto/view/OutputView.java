package lotto.view;

import static lotto.model.LottoRank.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoStatistic;

public class OutputView {
    public void printBoughtLottoList(List<Lotto> lottoList) {
        int count = lottoList.size();
        System.out.println("\n" + count + "개를 구매했습니다.");

        lottoList.forEach((lotto -> {
            System.out.println(lotto.getNumbers());
        }));

        System.out.println();
    }

    public void printLottoStatistic(LottoStatistic lottoStatistic) {
        HashMap<LottoRank, Integer> winningResult = lottoStatistic.getWinningResult();
        double profitRatio = lottoStatistic.getProfitRatio();
        String roundedRatio = String.format("%.1f", profitRatio);

        System.out.println("당첨 통계\n---");
        printEachResult(winningResult);
        System.out.println("총 수익률은 " + roundedRatio + "%입니다.");
    }

    private void printEachResult(HashMap<LottoRank, Integer> winningResult) {
        List<LottoRank> printRankList = List.of(RANK_5, RANK_4, RANK_3, RANK_2, RANK_1);
        DecimalFormat decimalFormat = new DecimalFormat();

        printRankList.forEach(rank -> {
            Integer winCount = winningResult.get(rank);
            String decimalPrizeMoney = decimalFormat.format(rank.prizeMoney);
            System.out.print(rank.matchCount + "개 일치");

            if (rank.matchBonus) {
                System.out.print(", 보너스 볼 일치");
            }

            System.out.println(" (" + decimalPrizeMoney + "원) - " + winCount + "개");
        });
    }
}
