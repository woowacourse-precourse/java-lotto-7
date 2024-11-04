package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수익률 테스트")
class StaticsTest {
    private Statics statics;

    @BeforeEach
    void setUp() {
        statics = new Statics();
    }

    @ParameterizedTest
    @CsvSource({"5000,5000,100", "2000,0,0", "10000,5000,50", "3000,10000,333.3f", "9000,5000,55.6f"})
    @DisplayName("수익률 계산을 제대로 하는지 확인하는 테스트")
    void calculateProfit(int spentMoney, int totalPrize, float profit) {
        assertThat(statics.calculateProfit(spentMoney, totalPrize)).isEqualTo(profit);
    }
}