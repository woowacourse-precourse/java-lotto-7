package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RevenueTest {
    @Test
    void 객체_생성_시에_수익률을_계산한다() {
        // given
        int purchaseAmount = 20000;
        int totalAmount = 200000;

        // when
        Revenue revenue = new Revenue(purchaseAmount, totalAmount);

        float actual = revenue.getReturnRate();
        float expected = (float) totalAmount / purchaseAmount * 100;

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
