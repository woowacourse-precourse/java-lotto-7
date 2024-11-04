package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningResultServiceTest {

    private WinningResultService winningResultService;
    private LottoTickets lottoTickets;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningResultService = new WinningResultService();
        lottoTickets = new LottoTickets((List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12))
        )));
        winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
    }

    @Test
    void 로또_티켓과_당첨번호를_비교하여_당첨결과를_계산한다() {
        WinningResult result = winningResultService.determineWinningRanks(lottoTickets, winningLotto);

        assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(1);  // 1등
        assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(1); // 2등
        assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(1);  // 3등
        assertThat(result.getRankCount(Rank.FOURTH)).isEqualTo(1); // 4등
        assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(1);  // 5등
    }

    @Test
    void 당첨된_로또가_없는_경우_결과는_모두_0이다() {
        LottoTickets noWinningTickets = new LottoTickets(List.of(
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(16, 17, 18, 19, 20, 21))
        ));

        WinningResult result = winningResultService.determineWinningRanks(noWinningTickets, winningLotto);

        assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(0);
        assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(0);
        assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(0);
        assertThat(result.getRankCount(Rank.FOURTH)).isEqualTo(0);
        assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(0);
    }

    @Test
    void 총_당첨금액을_정상적으로_계산한다() {
        WinningResult result = winningResultService.determineWinningRanks(lottoTickets, winningLotto);

        int totalPrize = result.calculateTotalPrize();
        assertThat(totalPrize).isEqualTo(
                Rank.FIRST.getPrize() +
                        Rank.SECOND.getPrize() +
                        Rank.THIRD.getPrize() +
                        Rank.FOURTH.getPrize() +
                        Rank.FIFTH.getPrize()
        );
    }

    @Test
    void 수익률을_정상적으로_계산한다() {
        int purchaseAmount = 5000;
        int totalPrize = Rank.FIRST.getPrize();

        double profitRate = winningResultService.calculateProfitRate(totalPrize, purchaseAmount);

        assertThat(profitRate).isEqualTo((double) totalPrize / purchaseAmount * 100);
    }
}
