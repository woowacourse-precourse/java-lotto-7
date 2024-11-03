package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.PrizeRank;

public class LottoTransactionView {
  final String STATISTICS_HEADER = "당첨 통계\n---";
  final String MATCH_DESCRIPTION_FORMAT = "%d개 일치";
  final String PRIZE_FORMAT = " (%,d원) - %d개";
  final String BONUS_MATCH_SUFFIX = ", 보너스 볼 일치";

  public void printWinningLottoStatistics(EnumMap<PrizeRank, Integer> rankCounts) {
    System.out.println(STATISTICS_HEADER);

    for (PrizeRank prizeRank : PrizeRank.values()) {
      String matchDescription = String.format(MATCH_DESCRIPTION_FORMAT, prizeRank.getCount());
      if (prizeRank == PrizeRank.LOSE) {
        continue;
      }
      if (prizeRank == PrizeRank.SECOND) {
        matchDescription += BONUS_MATCH_SUFFIX;
      }
      System.out.println(matchDescription + String.format(PRIZE_FORMAT, prizeRank.getPrize(),
              rankCounts.getOrDefault(prizeRank, 0)));
    }
  }


  public void printRateOfReturn(double rateOfReturn) {
    final String message = "총 수익률은 %.1f%입니다.";

    System.out.println(String.format(message, rateOfReturn));
  }

  public void printPurchasedLottoNumbers(List<Lotto> lottos) {
    String message = "%d개를 구매했습니다.";

    System.out.println(String.format(message, lottos.size()));

    for (Lotto lotto : lottos) {
      System.out.println(lotto.getNumbers());
    }
  }
}
