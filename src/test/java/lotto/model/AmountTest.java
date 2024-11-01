package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {
    @Test
    void 발행_금액_생성(){
        Amount amount = new Amount(15000);
        Assertions.assertThat(amount.getAmount()).isEqualTo(15000);
    }

    @Test
    void 발행하는_로또의_갯수_테스트(){
        Amount amount = new Amount(15500);
        Assertions.assertThat(amount.toCount()).isEqualTo(15);
    }

}