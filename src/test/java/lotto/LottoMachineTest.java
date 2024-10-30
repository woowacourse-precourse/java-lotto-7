package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

  @Test
  @DisplayName("유효한 구입 금액으로 로또 장수 계산 테스트")
  public void 로또_장수_계산_테스트() {
    LottoMachine lottoMachine = new LottoMachine();
    BigDecimal purchaseAmount = new BigDecimal("8000");
    int ticketCount = lottoMachine.calculateNumberOfTickets(purchaseAmount);
    assertEquals(8, ticketCount);
  }

  @Test
  @DisplayName("로또 번호 발행 테스트")
  public void 로또_번호_발행_테스트() {
    LottoMachine lottoMachine = new LottoMachine();
    int ticketCount = 5;
    List<Lotto> lottos = lottoMachine.generateLottoTickets(ticketCount);

    assertEquals(ticketCount, lottos.size());

    Set<List<Integer>> uniqueTickets = new HashSet<>();

    for (Lotto lotto : lottos) {
      List<Integer> numbers = lotto.getNumbers();

      assertEquals(6, numbers.size());

      for (int number : numbers) {
        assertTrue(number >= 1 && number <= 45);
      }

      List<Integer> sortedNumbers = new ArrayList<>(numbers);
      Collections.sort(sortedNumbers);
      assertEquals(sortedNumbers, numbers);

      assertTrue(uniqueTickets.add(numbers));
    }
  }

}
