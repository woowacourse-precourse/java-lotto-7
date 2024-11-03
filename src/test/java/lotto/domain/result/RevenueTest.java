package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RevenueTest {

    @DisplayName("구매 금액과 당첨금에 따라 수익률을 정확히 계산해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "0, 1, 0.0",
            "6000, 1, 600.0",
            "7000, 7, 100.0",
            "5000000, 5, 100000.0",
            "2000000, 10, 20000.0"
    })
    void should_CalculateCorrectProfitRate_When_PrizeAndPurchaseCountGiven(
            int totalPrize,
            int purchaseCount,
            double expectedProfitRate
    ) {
        // given
        Revenue revenue = Revenue.of(totalPrize, purchaseCount);

        // when
        double profitRate = revenue.calculateProfitRate();

        // then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}