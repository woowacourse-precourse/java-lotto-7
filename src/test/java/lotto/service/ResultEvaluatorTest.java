package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultEvaluatorTest {

  @DisplayName("로또 티켓의 당첨 결과를 정확히 평가한다")
  @Test
  void 로또_티켓의_당첨_결과를_정확히_평가한다() {
    List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
        new Lotto(List.of(1, 2, 3, 4, 5, 7)), new Lotto(List.of(1, 2, 3, 4, 5, 8)),
        new Lotto(List.of(1, 2, 3, 4, 7, 8)), new Lotto(List.of(1, 2, 3, 7, 8, 9)),
        new Lotto(List.of(1, 2, 7, 8, 9, 10)), new Lotto(List.of(7, 8, 9, 10, 11, 12)));

    WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
    BonusNumber bonusNumber = new BonusNumber(7, winningNumber);

    LottoEvaluator evaluator = new LottoEvaluator();
    Result result = evaluator.evaluateLottoTickets(lottos, winningNumber, bonusNumber);

    assertEquals(1, result.getRankCount(Rank.FIRST));
    assertEquals(1, result.getRankCount(Rank.SECOND));
    assertEquals(1, result.getRankCount(Rank.THIRD));
    assertEquals(1, result.getRankCount(Rank.FOURTH));
    assertEquals(1, result.getRankCount(Rank.FIFTH));
    assertEquals(2, result.getRankCount(Rank.MISS));
  }
}
