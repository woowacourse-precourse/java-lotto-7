package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class AmountTest {

    @Test
    void amount_생성확인_테스트() {
        Amount amount1 = new Amount(8000);

        int value = amount1.getPurchaseAmount();

        assertThat(value).isEqualTo(8000);
    }

    @Test
    void amount_생성실패_테스트() {
        int purchaseAmount = 8234;

        assertThatThrownBy(() -> new Amount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
