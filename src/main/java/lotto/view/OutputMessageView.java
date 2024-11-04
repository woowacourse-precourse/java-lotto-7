package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputMessageView {
  public void numberOfPurchases(long numberOfPurchases){
    System.out.println("\n"+numberOfPurchases+"개를 구매했습니다.");
  }

  public void winningStatistics(){
    System.out.println("---");
    System.out.println("---");
  }
  public void lottoResults(List<Lotto> lottos){
    for (Lotto lotto:lottos) {
      System.out.println(lotto.getNumbers());
    }
  }

}
