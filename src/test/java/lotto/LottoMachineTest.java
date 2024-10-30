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
import lotto.domain.Rank;
import lotto.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

  @Test
  @DisplayName("유효한 구입 금액으로 로또 장수 계산 테스트")
  void 로또_장수_계산_테스트() {
    LottoMachine lottoMachine = new LottoMachine();
    BigDecimal purchaseAmount = new BigDecimal("8000");
    int ticketCount = lottoMachine.calculateNumberOfTickets(purchaseAmount);
    assertEquals(8, ticketCount);
  }

  @Test
  @DisplayName("로또 번호 발행 테스트")
  void 로또_번호_발행_테스트() {
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

  @Test
  @DisplayName("3개 번호 일치 - 5등 판정 테스트")
  public void threeMatchTest() {
    LottoMachine lottoMachine = new LottoMachine();

    Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 20, 30));
    List<Lotto> lottos = List.of(lotto);
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;

    Result result = lottoMachine.evaluateLottoTickets(lottos, winningNumbers, bonusNumber);

    assertEquals(1, result.getRankCount(Rank.FIFTH));
    assertEquals(0, result.getRankCount(Rank.FOURTH));
    assertEquals(0, result.getRankCount(Rank.THIRD));
    assertEquals(0, result.getRankCount(Rank.SECOND));
    assertEquals(0, result.getRankCount(Rank.FIRST));
  }

  @Test
  @DisplayName("4개 번호 일치 - 4등 판정 테스트")
  public void fourMatchTest() {
    LottoMachine lottoMachine = new LottoMachine();

    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 20));
    List<Lotto> lottos = List.of(lotto);
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;

    Result result = lottoMachine.evaluateLottoTickets(lottos, winningNumbers, bonusNumber);

    assertEquals(0, result.getRankCount(Rank.FIFTH));
    assertEquals(1, result.getRankCount(Rank.FOURTH));
    assertEquals(0, result.getRankCount(Rank.THIRD));
    assertEquals(0, result.getRankCount(Rank.SECOND));
    assertEquals(0, result.getRankCount(Rank.FIRST));
  }

  @Test
  @DisplayName("5개 번호 일치 - 3등 판정 테스트")
  public void fiveMatchTest() {
    LottoMachine lottoMachine = new LottoMachine();

    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
    List<Lotto> lottos = List.of(lotto);
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;

    Result result = lottoMachine.evaluateLottoTickets(lottos, winningNumbers, bonusNumber);

    assertEquals(0, result.getRankCount(Rank.FIFTH));
    assertEquals(0, result.getRankCount(Rank.FOURTH));
    assertEquals(1, result.getRankCount(Rank.THIRD));
    assertEquals(0, result.getRankCount(Rank.SECOND));
    assertEquals(0, result.getRankCount(Rank.FIRST));
  }

  @Test
  @DisplayName("5개 번호 일치 + 보너스 번호 일치 - 2등 판정 테스트")
  public void fiveMatchWithBonusTest() {
    LottoMachine lottoMachine = new LottoMachine();

    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    List<Lotto> lottos = List.of(lotto);
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;

    Result result = lottoMachine.evaluateLottoTickets(lottos, winningNumbers, bonusNumber);

    assertEquals(0, result.getRankCount(Rank.FIFTH));
    assertEquals(0, result.getRankCount(Rank.FOURTH));
    assertEquals(0, result.getRankCount(Rank.THIRD));
    assertEquals(1, result.getRankCount(Rank.SECOND));
    assertEquals(0, result.getRankCount(Rank.FIRST));
  }

  @Test
  @DisplayName("6개 번호 일치 - 1등 판정 테스트")
  public void sixMatchTest() {
    LottoMachine lottoMachine = new LottoMachine();

    Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    List<Lotto> tickets = List.of(ticket);
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;

    Result result = lottoMachine.evaluateLottoTickets(tickets, winningNumbers, bonusNumber);

    assertEquals(0, result.getRankCount(Rank.FIFTH));
    assertEquals(0, result.getRankCount(Rank.FOURTH));
    assertEquals(0, result.getRankCount(Rank.THIRD));
    assertEquals(0, result.getRankCount(Rank.SECOND));
    assertEquals(1, result.getRankCount(Rank.FIRST));
  }

}
