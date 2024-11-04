package lotto.service.impl;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.Arrays;
import lotto.common.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceImplTest {
    private LottoServiceImpl lottoService;
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
        lottoService = new LottoServiceImpl(lottoMachine);
    }

    @Test
    void testPurchaseTickets() {
        int amount = 5000;

        LottoTickets tickets = lottoService.purchaseTickets(amount);

        assertSoftly(softly -> {
            softly.assertThat(tickets).isNotNull().as("Tickets should not be null");
            softly.assertThat(tickets.getLottoTickets()).hasSize(5).as("Should create 5 tickets for 5000 won");
        });
    }

    @Test
    void testCreateWinningNumbers() {
        Lotto winningLotto = Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningLotto winningNumbers = lottoService.createWinningNumbers(winningLotto, bonusNumber);

        assertSoftly(softly -> {
            softly.assertThat(winningNumbers).isNotNull().as("Winning numbers should not be null");
            softly.assertThat(winningNumbers.determineRank(Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6))))
                    .isEqualTo(LottoRank.FIRST)
                    .as("Winning numbers should match the FIRST rank ticket");
            softly.assertThatThrownBy(() -> lottoService.createWinningNumbers(winningLotto, 1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.")
                    .as("Bonus number should not be in the winning numbers");
        });
    }

    @Test
    void testCollectResults() {
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLotto(Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.addLotto(Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoTickets.addLotto(Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 8)));

        Lotto winningLottoWithoutBounsNumber = Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningLottoWithoutBounsNumber, 7);

        LottoStatistics statistics = lottoService.collectResults(lottoTickets, winningLotto);

        assertSoftly(softly -> {
            softly.assertThat(statistics.getResults().get(LottoRank.FIRST)).isEqualTo(1)
                    .as("1 ticket should match FIRST rank");
            softly.assertThat(statistics.getResults().get(LottoRank.SECOND)).isEqualTo(1)
                    .as("1 ticket should match SECOND rank");
            softly.assertThat(statistics.getResults().get(LottoRank.THIRD)).isEqualTo(1)
                    .as("1 ticket should match THIRD rank");
            softly.assertThat(statistics.getResults().get(LottoRank.NONE)).isEqualTo(0)
                    .as("No ticket should match NONE rank");
        });
    }

    @Test
    void testCalculateProfitRate() {
        int amount = 5000;
        lottoMachine.insertAmount(amount);

        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLotto(Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.addLotto(Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 7)));

        Lotto winningLottoWithoutBounsNumber = Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningLottoWithoutBounsNumber, 7);

        LottoStatistics statistics = lottoService.collectResults(lottoTickets, winningLotto);

        double profitRate = lottoService.calculateProfitRate(statistics);

        assertSoftly(softly -> {
            softly.assertThat(profitRate).isGreaterThan(0).as("Profit rate should be positive");
            softly.assertThat(profitRate).isNotNaN().as("Profit rate should not be NaN");
        });
    }
}