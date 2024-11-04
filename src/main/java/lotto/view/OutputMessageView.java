package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.LottoStatistics;

public class OutputMessageView {
  public void numberOfPurchases(long numberOfPurchases){
    System.out.println("\n"+numberOfPurchases+"개를 구매했습니다.");
  }

  public void winningStatistics(){
    System.out.println("당첨 통계");
    System.out.println("---");


  }
  public void lottoResults(List<Lotto> lottos){
    for (Lotto lotto:lottos) {
      System.out.println(lotto.getNumbers());
    }
  }

}
