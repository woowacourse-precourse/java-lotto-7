package lotto.winner;

import java.util.Arrays;
import java.util.List;
import lotto.io.input.Input;
import lotto.lotto.Lotto;
import lotto.lotto.LottoResult;
import lotto.lotto.LottoWinning;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinnerServiceTest {

    @AfterEach
    void close() {
        Input.close();
    }

    @Test
    void announceWinner() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Winner winner = new Winner(new Lotto(integers), 7);
        WinnerService winnerService = new WinnerService(winner);

        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 9, 8, 33)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        // when
        winnerService.announceWinner(lottos);

        // then
        LottoResult result = winnerService.getLottoResult();
        Assertions.assertEquals(1, result.getCount(LottoWinning.THREE_MATCH));
        Assertions.assertEquals(0, result.getCount(LottoWinning.FOUR_MATCH));
        Assertions.assertEquals(0, result.getCount(LottoWinning.FIVE_MATCH));
        Assertions.assertEquals(1, result.getCount(LottoWinning.FIVE_MATCH_WITH_BONUS_NUMBER));
        Assertions.assertEquals(1, result.getCount(LottoWinning.SIX_MATCH));
    }
}