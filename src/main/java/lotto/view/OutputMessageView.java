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
    statistics.forEach((prize, count) -> {
      if (prize != null) {
        System.out.println(
            prize.getMatchCount() + "개 일치 (" + prize.getPrize() + "원) - " + count + "개");
      }
    });
  }
  public void lottoResults(List<Lotto> lottos){
    for (Lotto lotto:lottos) {
      System.out.println(lotto.getNumbers());
    }
  }

}
