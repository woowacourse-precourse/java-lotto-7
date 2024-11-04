package lotto.application.statistics.service;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.PrizeNumberResult;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.prize.dto.PrizeResponse;
import lotto.application.statistics.dto.StatisticsResponse;
import lotto.application.ticket.domain.ticket.Lotto;
import lotto.application.ticket.dto.TicketResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsWriteServiceTest {

    private StatisticsWriteService statisticsWriteService;

    private PrizeResponse createPrizeResponse(List<Integer> winnerNumbers, int bonusNumber) {
        PrizeNumberResult prizeNumberResult = PrizeNumberResult.of(
                BonusNumber.of(bonusNumber, Lotto.of(winnerNumbers)), WinnerNumbers.of(Lotto.of(winnerNumbers))
        );
        return PrizeResponse.from(prizeNumberResult);
    }

    @BeforeEach
    void setUp() {
        statisticsWriteService = new StatisticsWriteService();
    }

    @Test
    @DisplayName("로또 통계 생성")
    void 로또_통계_생성() {
        // given
        List<Integer> winningNumbers = asList(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = asList(
                Lotto.of(asList(1, 2, 3, 4, 5, 6)),  // 1등
                Lotto.of(asList(1, 2, 3, 4, 5, 7)),  // 2등
                Lotto.of(asList(1, 2, 3, 4, 5, 8))  // 3등
        );

        TicketResponse ticketResponse = new TicketResponse(3, lottos, 3000);
        PrizeResponse prizeResponse = createPrizeResponse(winningNumbers, 7);

        // when
        StatisticsResponse response = statisticsWriteService.compile(ticketResponse, prizeResponse);

        // then
        assertThat(response).isNotNull();
        assertThat(response.profitRate()).isGreaterThan(0.0);
    }

    @Test
    @DisplayName("모든 로또가 미당첨이면 수익률은 0%")
    void 모든_로또가_미당첨이면_수익률은_영프로() {
        // given
        List<Integer> winningNumbers = asList(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = asList(
                Lotto.of(asList(40, 41, 42, 43, 44, 45)),
                Lotto.of(asList(34, 35, 36, 37, 38, 39))
        );

        TicketResponse ticketResponse = new TicketResponse(2, lottos, 2000);
        PrizeResponse prizeResponse = createPrizeResponse(winningNumbers, 7);

        // when
        StatisticsResponse response = statisticsWriteService.compile(ticketResponse, prizeResponse);

        // then
        assertThat(response.profitRate()).isZero();
    }

    @Test
    @DisplayName("수익률 계산하기 1등인 경우")
    void 수익률_계산하기_1등인_경우() {
        // given
        List<Integer> winningNumbers = asList(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = asList(
                Lotto.of(asList(1, 2, 3, 4, 5, 6))  // 1등
        );

        TicketResponse ticketResponse = new TicketResponse(1, lottos, 1000);
        PrizeResponse prizeResponse = createPrizeResponse(winningNumbers, 7);

        // when
        StatisticsResponse response = statisticsWriteService.compile(ticketResponse, prizeResponse);

        // then
        double expectedProfitRate = 200000000.0;
        assertThat(response.profitRate()).isEqualTo(expectedProfitRate);
    }

    @Test
    @DisplayName("여러 등수가 섞여 있을 때 수익률 계산하기")
    void 여러_등수가_섞여있을때_수익률_계산하기() {
        // given
        List<Integer> winningNumbers = asList(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = asList(
                Lotto.of(asList(1, 2, 3, 4, 5, 8)),  // 3등
                Lotto.of(asList(1, 2, 3, 4, 8, 9)),  // 4등
                Lotto.of(asList(1, 2, 3, 8, 9, 10))  // 5등
        );

        TicketResponse ticketResponse = new TicketResponse(3, lottos, 3000);
        PrizeResponse prizeResponse = createPrizeResponse(winningNumbers, 7);

        // when
        StatisticsResponse response = statisticsWriteService.compile(ticketResponse, prizeResponse);

        // then
        double expectedProfitRate = 51833.33;
        assertThat(response.profitRate()).isEqualTo(expectedProfitRate);
    }

}
