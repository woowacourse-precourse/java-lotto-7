package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

  @DisplayName("로또 티켓을 지정한 수만큼 생성한다")
  @Test
  void 로또_티켓을_지정한_수만큼_생성한다() {
    LottoMachine lottoMachine = new LottoMachine();
    int ticketCount = 5;
    List<Lotto> lottos = lottoMachine.generateLottoTickets(ticketCount);

    assertEquals(ticketCount, lottos.size());

    Set<List<Integer>> uniqueTickets = new HashSet<>();

    for (Lotto lotto : lottos) {
      List<Integer> numbers = lotto.getNumbers();

      assertEquals(6, numbers.size());

      for (int number : numbers) {
        assertTrue(number >= 1 && number <= 45, "로또 번호는 1부터 45 사이여야 합니다.");
      }

      List<Integer> sortedNumbers = new ArrayList<>(numbers);
      Collections.sort(sortedNumbers);
      assertEquals(sortedNumbers, numbers, "로또 번호는 정렬되어 있어야 합니다.");

      assertTrue(uniqueTickets.add(numbers), "중복된 로또 티켓이 생성되었습니다.");
    }
  }

}
