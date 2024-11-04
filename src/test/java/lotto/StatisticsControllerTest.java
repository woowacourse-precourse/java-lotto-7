package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StatisticsControllerTest {
    @Test
    @DisplayName("수익률 계산이 올바르게 수행된다.")
    void 수익률_계산_테스트() {
        StatisticsController statisticsController = new StatisticsController();
        double rateOfReturn = statisticsController.calculateRateOfReturn(5000, 8);
        assertThat(rateOfReturn).isEqualTo(62.5);
    }
}
