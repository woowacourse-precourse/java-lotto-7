package lotto.statistics;

import lotto.Prize;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    @Test
    void 당첨금_수입률_계산_테스트() {
        Statistics statistics = new Statistics();
        assertThat(statistics.rateOfReturn(Map.of(Prize.FIVE,1), 8)).isEqualTo(62.5);
    }

}