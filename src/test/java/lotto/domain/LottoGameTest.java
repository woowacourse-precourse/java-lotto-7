package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    private LottoGenerateStrategy strategy;
    private WinningTicket winningTicket;
    private ProfitCalculator profitCalculator;

    @BeforeEach
    void setUp() {
        strategy = () -> List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 8;
        winningTicket = new WinningTicket(winningNumbers, bonusNumber);
        int money = 5000;
        profitCalculator = new ProfitCalculator(money);
    }

    @DisplayName("구매한 티켓 개수를 반환한다")
    @Test
    void getPurchasedTicketsCount_returnsCorrectTicketCount() {
        LottoGame lottoGame = new LottoGame(profitCalculator, strategy, winningTicket);
        assertThat(lottoGame.getPurchasedTicketsCount()).isEqualTo(5);
    }

    @DisplayName("구매한 티켓 목록을 반환한다")
    @Test
    void getPurchasedTickets_returnsCorrectTicketList() {
        LottoGame lottoGame = new LottoGame(profitCalculator, strategy, winningTicket);
        String expectedTickets = "[1, 2, 3, 4, 5, 6]\n".repeat(5).trim();
        assertThat(lottoGame.getPurchasedTickets()).isEqualTo(expectedTickets);
    }

    @DisplayName("당첨 결과를 올바르게 계산하여 반환한다")
    @Test
    void getPrizes_returnsCorrectPrizeList() {
        LottoGame lottoGame = new LottoGame(profitCalculator, strategy, winningTicket);
        List<Prize> prizes = lottoGame.getPrizes();
        assertThat(prizes).containsOnly(Prize.FIVE);  // 각 티켓이 5개 일치
    }

    @DisplayName("수익률을 올바르게 계산한다")
    @Test
    void calculateEarningRate_returnsCorrectEarningRate() {
        LottoGame lottoGame = new LottoGame(profitCalculator, strategy, winningTicket);
        float earningRate = lottoGame.calculateEarningRate();
        assertThat(earningRate).isEqualTo(150000.0f);
    }
}
