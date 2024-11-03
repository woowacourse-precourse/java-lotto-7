package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("구입 가능한 로또 티켓수를 반환한다.")
    @Test
    void moneyGetTicketCount() {
        int validMoney = 12000;

        Money money = new Money(validMoney);
        int ticketCount = money.getTicketCount();

        assertEquals(12, ticketCount);
    }

    @DisplayName("구입 금액이 음수이면 예외가 발생한다.")
    @Test
    void moneyNotPositive() {
        int invalidMoney = -2000;

        assertThatThrownBy(() -> new Money(invalidMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 로또 구입 단위(1000원)으로 나눠지지 않으면 예외가 발생한다.")
    @Test
    void moneyNotDivisible() {
        int invalidMoney = 1200;

        assertThatThrownBy(() -> new Money(invalidMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
