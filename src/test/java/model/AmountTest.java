package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AmountTest {

    @Test
    void amount_생성확인() {
        Amount amount1 = new Amount(8000);

        int value = amount1.getPurchaseAmount();

        assertThat(value).isEqualTo(8000);
    }
}
