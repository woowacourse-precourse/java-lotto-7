package lotto.returnrate;

import java.util.Arrays;
import java.util.List;
import lotto.io.input.Input;
import lotto.lotto.Lotto;
import lotto.lotto.LottoWinning;
import lotto.winner.Winner;
import lotto.winner.WinnerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReturnRateTest {

    @AfterEach
    void close() {
        Input.close();
    }

    @Test
    @DisplayName("총 수익률 계산")
    void calculateReturnRate() {
        // given
        int purchaseAmount = 8000;

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Winner winner = new Winner(new Lotto(integers), 7);
        WinnerService winnerService = new WinnerService(winner);
        ReturnRate returnRate = new ReturnRate(winnerService.getLottoResult());

        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        winnerService.announceWinner(lottos);

        // when
        double calculateReturnRate = returnRate.calculateReturnRate(purchaseAmount);

        // then
        Assertions.assertEquals(calculateReturnRate, 62.5);
    }
}