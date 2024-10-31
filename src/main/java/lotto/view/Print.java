package lotto.view;

import java.util.List;
import lotto.domain.Handler;

public class Print {

  private Handler handler;
  // 발행한 로또를 조회하여 출력

  public void printGenerated(Handler handler, int request) {
    List<Integer> generated = handler.generateLotto(request);
    for (int i = 0; i < request; i++) {
      System.out.println(generated.get(i));
    }
  }

  // 7. 당첨 번호 / 보너스 번호 비교 결과를 조회하여 각각 당첨 통계와 수익률을 출력하고 애플리케이션 종료

}
