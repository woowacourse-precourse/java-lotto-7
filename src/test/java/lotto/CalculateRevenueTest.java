package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

class CalculateRevenueTest {

    private Map<Float, Integer> revenue;
    private int totalSpent;

    @BeforeEach
    void setUp() {
        revenue = new HashMap<>();
        revenue.put(5000f, 2);
        revenue.put(50000f, 1);
        totalSpent = 10000;
    }

    @Test
    @DisplayName("calculateTotalWinnings() 메서드가 총 당첨금을 정확하게 계산하는지 테스트")
    void 총_당첨금_확인() {
        CalculateRevenue calculateRevenue = new CalculateRevenue(revenue, totalSpent);

        float totalWinnings = calculateRevenue.calculateTotalWinnings();
        assertThat(totalWinnings).isEqualTo(60000f);
    }

    @Test
    @DisplayName("calculateRevenue() 메서드가 정확한 수익률을 계산하는지 테스트")
    void 수익률_계산_테스트() {
        CalculateRevenue calculateRevenue = new CalculateRevenue(revenue, totalSpent);

        float revenue = calculateRevenue.calculateRevenue(60000f);
        assertThat(revenue).isEqualTo(600f);
    }
}