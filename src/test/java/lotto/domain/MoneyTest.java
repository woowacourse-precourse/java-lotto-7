package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 돈을_생성하면_금액이_저장된다() {
        //given
        int amount = 1000;

        //when
        Money result = Money.from(amount);

        //then
        assertThat(result.getAmount()).isEqualTo(1000);
    }

    @Test
    void 금액이_1000원_보다_작으면_예외가_발생한다() {
        //given
        int amount = 999;

        //expected
        assertThatThrownBy(() -> Money.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 1000원 이상, 100000원 이하 입니다.");
    }

    @Test
    void 금액이_100000원_보다_크면_예외가_발생한다() {
        //given
        int amount = 100001;

        //expected
        assertThatThrownBy(() -> Money.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 1000원 이상, 100000원 이하 입니다.");
    }

    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        //given
        int amount = 1500;

        //expected
        assertThatThrownBy(() -> Money.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 1000원 단위입니다.");
    }

    @Test
    void 금액이_null이면_예외가_발생한다() {
        //given
        Integer amount = null;

        //expected
        assertThatThrownBy(() -> Money.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Money에 전달된 파라미터가 null입니다.");
    }
}
