package lotto.winner;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.LottoWinning;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WinnerServiceTest {

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
        Assertions.assertEquals(LottoWinning.THREE_MATCH.getCount(), 1);
        Assertions.assertEquals(LottoWinning.FOUR_MATCH.getCount(), 0);
        Assertions.assertEquals(LottoWinning.FIVE_MATCH.getCount(), 0);
        Assertions.assertEquals(LottoWinning.FIVE_MATCH_WITH_BONUS_NUMBER.getCount(), 1);
        Assertions.assertEquals(LottoWinning.SIX_MATCH.getCount(), 1);
    }
}