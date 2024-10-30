package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;

public class OutputView {

  public void printLottoTickets(List<Lotto> lottos) {
    System.out.println(lottos.size() + "개를 구매했습니다.");
    for (Lotto lotto : lottos) {
      System.out.println(lotto.getNumbers());
    }
  }

  public void printResult(Result result, BigDecimal purchaseAmount) {
    System.out.println("당첨 통계");
    System.out.println("---");

    Map<Rank, Integer> rankCounts = result.getRankCounts();

    System.out.println("3개 일치 (5,000원) - " + rankCounts.get(Rank.FIFTH) + "개");
    System.out.println("4개 일치 (50,000원) - " + rankCounts.get(Rank.FOURTH) + "개");
    System.out.println("5개 일치 (1,500,000원) - " + rankCounts.get(Rank.THIRD) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts.get(Rank.SECOND) + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts.get(Rank.FIRST) + "개");

    long totalPrize = result.calculateTotalPrize();
    BigDecimal profitRate = BigDecimal.valueOf(totalPrize)
        .divide(purchaseAmount, 3, BigDecimal.ROUND_HALF_UP)
        .multiply(BigDecimal.valueOf(100))
        .setScale(1, BigDecimal.ROUND_HALF_UP);

    System.out.println("총 수익률은 " + profitRate + "%입니다.");
  }

}
