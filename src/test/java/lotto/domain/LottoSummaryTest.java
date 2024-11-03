package lotto.domain;

import lotto.strategy.LottoCreateStrategy;
import lotto.strategy.RandomLottoCreateStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoSummaryTest {
    @Test
    void 수익률을_계산한다() {
        //Arrange
        Budget budget = new Budget(8000);
        List<Lotto> lottoTickets = List.of(
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(3, 4, 5, 9, 7, 8))
        );

        List<Integer> winningLotto = List.of(1,2,3,4,5,6);
        WinningNumber winningNumber = new WinningNumber(new Lotto(winningLotto), 17);

        //Act
        LottoSummary lottoSummary = new LottoSummary(lottoTickets, winningNumber, budget);
        double rateOfReturn = lottoSummary.getRateOfReturn();

        //Assert
        assertEquals(62.5, rateOfReturn);
    }
}
