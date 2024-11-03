package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @DisplayName("로또 당첨 결과를 반환한다.")
    @Test
    void getLottoRank() {
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),   // FIRST
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),  // SECOND (bonusNumber==10)
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),  // THIRD
                new Lotto(List.of(1, 2, 3, 4, 7, 45)),  // FOURTH
                new Lotto(List.of(1, 2, 3, 7, 8, 45)),  // FIFTH
                new Lotto(List.of(1, 2, 3, 7, 9, 45))   // FIFTH
        ));

        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers.getNumbers(), bonusNumber);

        LottoRank lottoRank = new LottoRank(lottoTickets, winningLotto);

        Map<Rank, Integer> ranks = lottoRank.getLottoRank();
        assertEquals(1, ranks.get(Rank.FIRST));
        assertEquals(1, ranks.get(Rank.SECOND));
        assertEquals(1, ranks.get(Rank.THIRD));
        assertEquals(1, ranks.get(Rank.FOURTH));
        assertEquals(2, ranks.get(Rank.FIFTH));
        assertNull(ranks.get(Rank.MISS));
    }
}
