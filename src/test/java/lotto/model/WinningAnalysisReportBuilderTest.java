package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.WinningNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningAnalysisReportBuilderTest {

    private Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private LottoTicket createLottoTicket(Lotto lotto, Money price) {
        return new LottoTicket(lotto, price);
    }

    private LottoTickets createLottoTickets(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    private WinningNumbers createWinningNumbers(Lotto mainNumbers, int bonusNumber) {
        return new WinningNumbers(mainNumbers, bonusNumber);
    }

    @DisplayName("WinningAnalysisReport를 성공적으로 생성할 수 있다.")
    @Test
    void winningAnalysisReport_생성_성공() {
        Lotto lotto1 = createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = createLotto(List.of(7, 8, 9, 10, 11, 12));
        Money price1 = Money.of(1000);
        Money price2 = Money.of(1000);

        LottoTicket ticket1 = createLottoTicket(lotto1, price1);
        LottoTicket ticket2 = createLottoTicket(lotto2, price2);
        LottoTickets lottoTickets = createLottoTickets(List.of(ticket1, ticket2));
        WinningNumbers winningNumbers = createWinningNumbers(lotto1, 7);

        WinningAnalysisReport report = WinningAnalysisReport.builder()
                .withLottoTickets(lottoTickets)
                .withWinningNumbers(winningNumbers)
                .build();

        assertThat(report).isNotNull();
        assertThat(report.winningStatistics()).isNotNull();
        assertThat(report.profitRate()).isNotNull();
    }

    @DisplayName("WinningAnalysisReportBuilder에 null LottoTickets를 설정할 수 없다.")
    @Test
    void winningAnalysisReportBuilder_LottoTickets_null() {
        WinningAnalysisReportBuilder builder = new WinningAnalysisReportBuilder();

        assertThatThrownBy(() -> builder.withLottoTickets(null))
                .isInstanceOf(WinningNumberException.class)
                .hasMessage(ErrorMessages.LOTTO_TICKETS_NULL.getMessage());
    }

    @DisplayName("WinningAnalysisReportBuilder에 빈 LottoTickets를 설정할 수 없다.")
    @Test
    void winningAnalysisReportBuilder_빈_LottoTickets() {
        WinningAnalysisReportBuilder builder = new WinningAnalysisReportBuilder();

        assertThatThrownBy(() -> builder.withLottoTickets(createLottoTickets(List.of())))
                .isInstanceOf(WinningNumberException.class)
                .hasMessage(ErrorMessages.LOTTO_TICKETS_NULL.getMessage());
    }

    @Nested
    @DisplayName("WinningAnalysisReportBuilder에서 WinningNumbers 관련 예외 처리")
    class WinningNumbersTests {

        @DisplayName("WinningAnalysisReportBuilder에 null WinningNumbers를 설정할 수 없다.")
        @Test
        void winningAnalysisReportBuilder_WinningNumbers_null_설정_불가() {
            WinningAnalysisReportBuilder builder = new WinningAnalysisReportBuilder();
            LottoTickets lottoTickets = createLottoTickets(List.of(createLottoTicket(createLotto(List.of(1, 2, 3, 4, 5, 6)), Money.of(1000))));

            builder.withLottoTickets(lottoTickets);

            assertThatThrownBy(() -> builder.withWinningNumbers(null))
                    .isInstanceOf(WinningNumberException.class)
                    .hasMessage(ErrorMessages.WINNING_NUMBERS_NULL.getMessage());
        }

        @DisplayName("WinningAnalysisReportBuilder에 WinningNumbers가 null인 경우 예외 발생.")
        @Test
        void winningAnalysisReportBuilder_WinningNumbers_null_예외발생() {
            WinningAnalysisReportBuilder builder = new WinningAnalysisReportBuilder();
            LottoTickets lottoTickets = createLottoTickets(List.of(createLottoTicket(createLotto(List.of(1, 2, 3, 4, 5, 6)), Money.of(1000))));

            builder.withLottoTickets(lottoTickets);

            assertThatThrownBy(builder::build)
                    .isInstanceOf(WinningNumberException.class)
                    .hasMessage(ErrorMessages.WINNING_NUMBERS_NULL.getMessage());
        }
    }
}
