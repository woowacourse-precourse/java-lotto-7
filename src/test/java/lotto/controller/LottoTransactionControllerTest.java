package lotto.controller;

import java.util.Arrays;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LottoTransactionControllerTest {

  private LottoTransactionController controller;

  @BeforeEach
  public void setUp() {
    controller = new LottoTransactionController();
  }

  @Test
  public void 로또_구매_기능() {
    int money = 5000;
    List<Lotto> lottos = controller.sellAutoLotto(money);

    assertEquals(5, lottos.size(), "5개를 구매했습니다.");
  }

  @Test
  public void 로또_구매_0원_금액() {
    int money = 0;
    List<Lotto> lottos = controller.sellAutoLotto(money);

    // TODO 0원 처럼 아예 살 수 없는 경우 예외처리 class 정하기
    assertEquals(0, lottos.size(), "0원의 금액으로는 로또를 구매할 수 없습니다.");
  }

  @Test
  public void 로또_당첨번호_비교() { // TODO test용 삭제 또는 수정 예정
    int money = 5000;
    List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    List<Lotto> lottos = controller.sellAutoLotto(money);

    controller.compareWinningNumbers(winningNumbers, 45);
  }


}
