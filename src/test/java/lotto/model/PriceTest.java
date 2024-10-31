package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PriceTest {
    @Test
    void 가격이_1000원_미만일_경우_예외발생() {
        int invalidAmount = 500;

        assertThatThrownBy(() -> new Price(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 가격이_1000원_단위가_아닐_경우_예외발생() {
        int invalidAmount = 1500;

        assertThatThrownBy(() -> new Price(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액을_티켓수로_변환() {
        Price price = new Price(3000);

        int ticketCount = price.convertToTicket();

        assertThat(ticketCount).isEqualTo(3);
    }
}
