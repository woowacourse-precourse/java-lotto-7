package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.Handler;

public class Print {

  private Input input;
  private Lotto lotto;
  private Handler handler;

  public Print(Handler handler, Input input, Lotto lotto) {
    this.handler = handler;
    this.input = input;
    this.lotto = lotto;
  }

  // 발행한 로또를 조회하여 출력
  public void printGenerated(List<List<Integer>> lotto) {
    int lottoCounts = lotto.size();
    String format = String.format("%d개를 구매했습니다.\n", lottoCounts);
    System.out.println(format);
    for(List<Integer> eachLotto : lotto) {
      System.out.println(eachLotto.toString());
    }
  }

  // 7. 당첨 번호 / 보너스 번호 비교 결과를 조회하여 각각 당첨 통계를 출력
  public void printResult() {
    String winningNumbers = input.readWinning();
    int amount = input.readAmount();
    int request = input.getLottoCounts(amount);
    handler.generateLotto();
    Lotto lotto = new Lotto(handler.generateLotto());
    String result = handler.compareNumbersResult(lotto.responseLottoCounts(request), handler.getWinning(winningNumbers), handler.getBonus());
    System.out.println(result);
  }

  // 메서드 분리 : 수익률 출력
  public void printMetric(String result, int amount) {
    double revenue = handler.valueationRevenue(result, amount);
    System.out.println(revenue);
  }

}
