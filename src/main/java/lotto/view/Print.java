package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Handler;

public class Print {

  private Handler handler;
  // 발행한 로또를 조회하여 출력

  public void printGenerated(int request) {
    String format = String.format("%d개를 구매했습니다.", request);
    System.out.println(format);
    List<List<Integer>> eachGenerated = new ArrayList<>();
    for (int i = 0; i < request; i++) {
      System.out.println(eachGenerated.get(i));
    }
  }

  // 7. 당첨 번호 / 보너스 번호 비교 결과를 조회하여 각각 당첨 통계를 출력
  public void printResult(Handler handler) {
    handler = this.handler;
    Input input = new Input("8000");
    int amount = input.readAmount();
    String result = handler.compareNumbersResult(handler.generateLotto(), handler.getWinning(), handler.getBonus());
    System.out.println(result);
  }

  // 메서드 분리 : 수익률 출력
  public void printRevenue(String result, int amount) {
    double revenue = handler.calculateRevenue(result, amount);
    System.out.println(revenue);
  }

}
