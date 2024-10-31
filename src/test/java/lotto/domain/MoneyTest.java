package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void 구입금액이_천원단위가아니면_예외가발생한다(){
        assertThatThrownBy(()->
                new Money(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}