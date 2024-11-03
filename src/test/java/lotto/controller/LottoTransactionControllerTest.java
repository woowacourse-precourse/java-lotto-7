package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.PrizeRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LottoTransactionControllerTest {

  private LottoTransactionController controller;
  private List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
  Map<List<Integer>, PrizeRank> lottoPrizeData = Map.of(
          Arrays.asList(1, 2, 3, 4, 5, 6), PrizeRank.FIRST,
          Arrays.asList(1, 2, 3, 4, 5, 45), PrizeRank.SECOND,
          Arrays.asList(1, 2, 3, 4, 5, 18), PrizeRank.THIRD,
          Arrays.asList(1, 2, 3, 4, 23, 24), PrizeRank.FOURTH,
          Arrays.asList(1, 2, 3, 28, 29, 30), PrizeRank.FIFTH
  );

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

  @Test
  public void 로또_당첨번호_비교_테스트() {
    List<List<Integer>> lottoNumbers = getKeysFromMap(lottoPrizeData);

    controller.sellManualLotto(lottoNumbers, 5000);
    //TODO  compareWinningNumbers() 리턴 받기, 리턴값 수정
    /**
     *  ex)  Map<List<Integer>, PrizeRank> Map변수1 = controller.compareWinningNumbers()
     * */

    //TODO lottoNumbers 가지고 Map변수1와 this.winningNumbers 값 비교
    /**
     *  ex)    for {
     *    key  = Map변수1.getkey()
     *    assertEquals(Map변수1[key], this.winningNumbers[key])
     *  }
     * */

  }


  private List<List<Integer>> getKeysFromMap(Map<List<Integer>, PrizeRank> data) {
    return new ArrayList<>(data.keySet());
  }


}
