package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 정상_생성_테스트() {
        Money money = new Money(1000);

        assertNotNull(money);
        assertEquals(1000, money.money());
    }

    @Test
    void 금액이_천원보다_작은_경우_테스트() {
        assertThatThrownBy(() -> new Money(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_NOT_GREATER_THAN_A_THOUSAND.getMessage());
    }

    @Test
    void 금액이_천원으로_나누어_떨어지지_않을_경우_테스트() {
        assertThatThrownBy(() -> new Money(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_NOT_MULTIPLE_OF_THOUSAND.getMessage());
    }
}