package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 당첨_결과_count() {
        // given
        LottoTickets lottoTickets = new LottoTickets("1000");
        Lotto lotto = lottoTickets.getLottos().getFirst();
        List<Integer> winningNumbers = lotto.getNumbers();

        int bonusNumber = 0;
        for (int i=1; i<=45; i++) {
            if (!winningNumbers.contains(i)) {
                bonusNumber = i;
                break;
            }
        }

        BallNumber ballNumber = new BallNumber(winningNumbers, bonusNumber);

        // when
        Winning winning = lottoService.countWinning(lottoTickets, ballNumber);

        // then
        assertThat(winning.getCount(Rank.RANK_1)).isEqualTo(1);
    }

    @Test
    void 수익률_계산() {
        // given
        LottoTickets lottoTickets = new LottoTickets("4000");

        Winning winning = new Winning();
        winning.increaseWinningCount(Rank.RANK_4);
        winning.increaseWinningCount(Rank.RANK_5);

        // when
        double rateOfReturn = lottoService.calculateRateOfReturn(lottoTickets, winning);

        // then
        assertThat(rateOfReturn).isEqualTo(1375.0);
    }

}