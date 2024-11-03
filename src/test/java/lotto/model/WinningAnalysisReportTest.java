package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.WinningNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningAnalysisReportTest {

    @DisplayName("WinningAnalysisReport을 생성할 수 있다.")
    @Test
    void winningAnalysisReport_생성() {
        WinningStatistics statistics = new WinningStatistics();
        ProfitRate profitRate = ProfitRate.from(5000, Money.of(10000));

        WinningAnalysisReport report = new WinningAnalysisReport(statistics, profitRate);

        assertThat(report).isNotNull();
        assertThat(report.winningStatistics()).isEqualTo(statistics);
        assertThat(report.profitRate()).isEqualTo(profitRate);
    }

    @DisplayName("WinningStatistics가 null인 경우 예외가 발생한다.")
    @Test
    void winningStatistics_null_예외() {
        ProfitRate profitRate = ProfitRate.from(5000, Money.of(10000));

        assertThatThrownBy(() -> new WinningAnalysisReport(null, profitRate))
                .isInstanceOf(WinningNumberException.class)
                .hasMessage(ErrorMessages.WINNING_STATISTICS_NULL.getMessage());
    }

    @DisplayName("ProfitRate가 null인 경우 예외가 발생한다.")
    @Test
    void profitRate_null_예외() {
        WinningStatistics statistics = new WinningStatistics();

        assertThatThrownBy(() -> new WinningAnalysisReport(statistics, null))
                .isInstanceOf(WinningNumberException.class)
                .hasMessage(ErrorMessages.PROFIT_RATE_NULL.getMessage());
    }

    @DisplayName("toString() 메소드가 올바른 형식으로 반환된다.")
    @Test
    void toString_테스트() {
        WinningStatistics statistics = new WinningStatistics();
        ProfitRate profitRate = ProfitRate.from(5000, Money.of(10000));

        WinningAnalysisReport report = new WinningAnalysisReport(statistics, profitRate);

        String expectedString = statistics + String.format("\n총 수익률은 %.1f%%입니다.", profitRate.getRate());
        assertThat(report.toString()).isEqualTo(expectedString);
    }
}

