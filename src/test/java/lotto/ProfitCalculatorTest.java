package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    @Test
    void 총_당첨금이_0이고_로또_개수가_1일_때_수익률은_0이다() throws Exception {
        // given
        int totalWinningPrice = 0;
        int lottoCount = 1;
        // when
        double result = ProfitCalculator.calculateProfitRate(totalWinningPrice, lottoCount);

        // then
        assertThat(result).isEqualTo(0.0);
    }

    @Test
    void 총_당첨금이_10_000이고_로또_개수가_1일_때_수익률은_1000이다() throws Exception {
        // given
        int totalWinningPrice = 10_000;
        int lottoCount = 1;
        // when
        double result = ProfitCalculator.calculateProfitRate(totalWinningPrice, lottoCount);

        // then
        assertThat(result).isEqualTo(1000.0);
    }

    @Test
    void 총_당첨금이_15_000이고_로또_개수가_2일_때_수익률은_750이다() throws Exception {
        // given
        int totalWinningPrice = 15_000;
        int lottoCount = 2;
        // when
        double result = ProfitCalculator.calculateProfitRate(totalWinningPrice, lottoCount);

        // then
        assertThat(result).isEqualTo(750.0);
    }

    @Test
    void 총_당첨금이_5_000이고_로또_개수가_8일_때_수익률은_62_5이다() throws Exception {
        // given
        int totalWinningPrice = 5_000;
        int lottoCount = 8;
        // when
        double result = ProfitCalculator.calculateProfitRate(totalWinningPrice, lottoCount);

        // then
        assertThat(result).isEqualTo(62.5);
    }

}