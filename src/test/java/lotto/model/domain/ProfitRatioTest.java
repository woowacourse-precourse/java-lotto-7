package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProfitRatioTest {

    @Test
    void 수익률_생성() {
        //given
        int prize = 50000;
        int purchaseAmount = 3000;

        //when
        ProfitRatio profitRatio = new ProfitRatio(prize, purchaseAmount);

        //then
        Assertions.assertThat(profitRatio.get()).isEqualTo(1666.7);
        Assertions.assertThat(profitRatio.getFormatted()).isEqualTo("1,666.7%");

    }

}