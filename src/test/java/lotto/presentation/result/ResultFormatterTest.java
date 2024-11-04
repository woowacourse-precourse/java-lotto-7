package lotto.presentation.result;

import static java.math.BigDecimal.valueOf;
import static lotto.presentation.result.ResultFormatter.formatLottoNumberMessage;
import static lotto.presentation.result.ResultFormatter.formatPurchaseCountMessage;
import static lotto.presentation.result.ResultFormatter.formatReturnOnInvestmentMessage;
import static lotto.presentation.result.ResultFormatter.formatWinningStatisticsMessage;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.service.dto.WinningResult;

class ResultFormatterTest {

    @DisplayName("구매한 로또 개수 결과를 알려준다.")
    @Test
    void 구매_개수_메시지_포맷() {
        assertThat(formatPurchaseCountMessage(10))
                .isEqualTo("10개를 구매했습니다.");
    }

    @DisplayName("발행된 로또의 번호 6개를 [ ]안에 1개씩 구분해 알려준다.")
    @Test
    void 발행_로또_번호_메시지_포맷() {
        assertThat(formatLottoNumberMessage(List.of("1", "2", "3", "4", "5", "6")))
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("당첨에 필요한 조건 정보와 당첨된 로또 개수를 알려준다.")
    @Test
    void 당첨_통계_메시지_포맷() {
        WinningResult winningResult = new WinningResult(5, 1_500_000L, false);
        String winningCount = "1";

        assertThat(formatWinningStatisticsMessage(winningResult, winningCount))
                .isEqualTo("5개 일치 (1,500,000원) - 1개");
    }

    @DisplayName("2등 당첨에 필요한 조건 정보와 당첨된 로또 개수를 알려준다.")
    @Test
    void 당첨_통계_2등_메시지_포맷() {
        WinningResult winningResult = new WinningResult(5, 30_000_000L, true);
        String winningCount = "1";

        assertThat(formatWinningStatisticsMessage(winningResult, winningCount))
                .isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
    }

    @DisplayName("수익을 소수점 둘째 자리에서 반올림한 수익율로 알려준다.")
    @CsvSource(value = {"1.0 100.0%", "0.5154 51.5%", "10000.0004 1,000,000.0%"}, delimiter = ' ')
    @ParameterizedTest
    void 수익률_메시지_포맷(double returnOnInvestment, String expected) {
        assertThat(formatReturnOnInvestmentMessage(valueOf(returnOnInvestment)))
                .isEqualTo("총 수익률은 " + expected + "입니다.");
    }

}
