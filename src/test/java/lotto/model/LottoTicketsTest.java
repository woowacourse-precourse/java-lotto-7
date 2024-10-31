package lotto.model;

import static lotto.model.LottoRank.FIRST;
import static lotto.model.LottoRank.SECOND;
import static lotto.model.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.EnumMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    @DisplayName("총 당첨 상금 금액을 반환한다.")
    void should_ReturnTotalPrizeFromWinningLotto() {
        // given
        Lotto firstLottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoTickets lottoTickets = new LottoTickets(List.of(firstLottoTicket, secondLottoTicket));

        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        // when
        BigInteger prize = lottoTickets.calculateWinningPrize(winningLotto);

        // then
        assertEquals(prize, BigInteger.valueOf(FIRST.getPrize() + SECOND.getPrize()));
    }

    @Test
    @DisplayName("당첨 등수를 모두 반환한다.")
    void should_ReturnAllLottoRanks() {
        // given
        Lotto firstLottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto secondLottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdLottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = new LottoTickets(List.of(firstLottoTicket, secondLottoTicket, thirdLottoTicket));

        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        // when
        EnumMap<LottoRank, Integer> ranks = lottoTickets.calculateAllRanks(winningLotto);

        // then
        int firstPlaceCount = ranks.getOrDefault(FIRST, 0);
        int secondPlaceCount = ranks.getOrDefault(SECOND, 0);
        int thirdPlaceCount = ranks.getOrDefault(THIRD, 0);

        assertAll(
                () -> assertThat(firstPlaceCount).isOne(),
                () -> assertThat(secondPlaceCount).isOne(),
                () -> assertThat(thirdPlaceCount).isOne()
        );
    }
}
