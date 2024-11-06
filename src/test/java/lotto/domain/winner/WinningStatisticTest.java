package lotto.domain.winner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.common.Price;
import lotto.domain.lotto.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 통계를 테스트한다.")
class WinningStatisticTest {

    @DisplayName("당첨 수를 테스트한다.")
    @Test
    void countWinnerTest() {
        List<LottoResult> results = new ArrayList<>();
        results.addAll(generateSuccessResults());
        results.addAll(generateFailureResults());
        WinningStatistic winningStatistic = WinningStatistic.from(results, generatePrice(8000));

        List<WinnerFrequency> winnerFrequencies = winningStatistic.getWinnerFrequencies();

        assertThat(winnerFrequencies.size()).isSameAs(5);
    }

    @DisplayName("수익률을 테스트한다.")
    @Test
    void profitRateTest() {
        List<LottoResult> results = new ArrayList<>();
        results.addAll(generateSuccessResults());
        results.addAll(generateFailureResults());
        WinningStatistic winningStatistic = WinningStatistic.from(results, generatePrice(8000));

        String formattedProfitRate = winningStatistic.getFormattedProfitRate();

        assertThat(formattedProfitRate).isEqualTo("총 수익률은 25394437.5%입니다.");
    }

    private List<LottoResult> generateSuccessResults() {
        return List.of(
                new LottoResult(3, false),
                new LottoResult(4, false),
                new LottoResult(5, false),
                new LottoResult(5, true),
                new LottoResult(6, false)
        );
    }

    private List<LottoResult> generateFailureResults() {
        return List.of(
                new LottoResult(3, true),
                new LottoResult(4, true),
                new LottoResult(6, true)
        );
    }

    private static Price generatePrice(int money) {
        return new Price(money);
    }
}