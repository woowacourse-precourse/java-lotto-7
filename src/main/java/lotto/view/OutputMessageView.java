package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.util.LottoStatistics;

public class OutputMessageView {
  public void numberOfPurchases(long numberOfPurchases){
    System.out.println("\n"+numberOfPurchases+"개를 구매했습니다.");
  }

  public void winningStatistics(Map<LottoPrize, Integer> statistics){
    System.out.println("당첨 통계");
    System.out.println("---");

    for (LottoPrize prize : LottoPrize.values()) {
      int count = statistics.getOrDefault(prize, 0);
      String formattedPrize = String.format("%,d", prize.getPrize()); // 쉼표 포맷팅
      if(prize.equals(LottoPrize.FIVE_MATCH_BONUS)){
        System.out.println(prize.getMatchCount() + "개 일치, 보너스 볼 일치 (" + formattedPrize + "원) - " + count + "개");
        continue;
      }
      System.out.println(prize.getMatchCount() + "개 일치 (" + formattedPrize + "원) - " + count + "개");
    }
  }
  public void lottoResults(List<Lotto> lottos){
    for (Lotto lotto:lottos) {
      System.out.println(lotto.getNumbers());
    }
  }

  public void rateOfReturn(double rateOfReturn) {
    System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
  }
}
