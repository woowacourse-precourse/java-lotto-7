package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 구매_금액은_천원_단위가_아니면_예외가_발생합니다() {
        //given
        int moneyInput = 1200;

        //when
        //then
        Assertions.assertThatThrownBy(() -> {
                    new Money(moneyInput);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로 구매 가능 합니다.");
    }
}