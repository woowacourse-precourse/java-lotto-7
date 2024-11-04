package lotto.model.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.handler.MoneyErrorHandler;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 돈_생성_테스트() {
        //given,when
        Money money = new Money(1000);

        //then
        assertThat(1000)
                .isEqualTo(money.value());
    }

    @Test
    void 돈_생성_단위_예외_테스트() {
        //given
        int moneyInfo = 1500;

        //when,then
        assertThatThrownBy(
                () -> new Money(moneyInfo)
        ).isInstanceOf(MoneyErrorHandler.class);
    }

    @Test
    void 돈_생성_음수_예외_테스트() {
        //given
        int moneyInfo = -100;

        //when,then
        assertThatThrownBy(
                () -> new Money(moneyInfo)
        ).isInstanceOf(MoneyErrorHandler.class);
    }
}
