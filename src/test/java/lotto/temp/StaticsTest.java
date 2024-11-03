package lotto.temp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StaticsTest {
    private Statics statics;

    @BeforeEach
    void setUp() {
        statics = new Statics();
    }

    @Test
    @DisplayName("수익률 계산을 제대로 하는지 확인하는 테스트")
    void calculateProfit(){
        assertThat(statics.calculateProfit(5000, 5000)).isEqualTo(100);
        assertThat(statics.calculateProfit(2000, 0)).isEqualTo(0);
        assertThat(statics.calculateProfit(10000, 5000)).isEqualTo(50);
        assertThat(statics.calculateProfit(3000, 10000)).isEqualTo(333.3f);
        assertThat(statics.calculateProfit(9000, 5000)).isEqualTo(55.6f);
    }
}