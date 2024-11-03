package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitRateTest {

    @Test
    @DisplayName("수익률을 구한다.")
    void getProfitRate() {
        //given
        double purchaseAmount = 10000.0;
        double totalPrize = 1000.0;

        //when
        ProfitRate profitRate = ProfitRate.of(purchaseAmount, totalPrize);

        //then
        assertThat(profitRate.getProfitRate()).isEqualTo(10.0);
    }

}