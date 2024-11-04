package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {

    public void showLotties(List<Lotto> lotties) {
        System.out.println(lotties.size() + "개를 구매했습니다.");
        for (Lotto lotto : lotties) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showResult(List<Rank> ranks) {
        int totalFifth = Collections.frequency(ranks, Rank.FIFTH);
        int totalFourth = Collections.frequency(ranks, Rank.FOURTH);
        int totalThird = Collections.frequency(ranks, Rank.THIRD);
        int totalSecond = Collections.frequency(ranks, Rank.SECOND);
        int totalFirst = Collections.frequency(ranks, Rank.FIRST);
        double rateOfReturn = calculateTotalReturn(ranks);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + totalFifth + "개");
        System.out.println("4개 일치 (50,000원) - " + totalFourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + totalThird + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalSecond + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + totalFirst + "개");
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    private double calculateTotalReturn(List<Rank> ranks) {
        int totalPurchaseAmount = ranks.size() * 1_000;
        int totalReturn = 0;
        for (Rank rank : ranks) {
            totalReturn += rank.getWinningPrize();
        }
        return (double) totalReturn / totalPurchaseAmount * 100;
    }
}