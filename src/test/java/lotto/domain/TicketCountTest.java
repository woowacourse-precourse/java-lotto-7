package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketCountTest {

    @Test
    void 유효한_금액으로_티켓_개수를_계산한다() {
        TicketCount ticketCount = new TicketCount("5000");
        assertThat(ticketCount.getCount()).isEqualTo(5);
    }

    @Test
    void 유효하지_않은_금액으로_티켓_개수를_계산할_때_예외가_발생한다() {
        assertThatThrownBy(() -> new TicketCount("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_0일_때_예외가_발생한다() {
        assertThatThrownBy(() -> new TicketCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_숫자가_아닐_때_예외가_발생한다() {
        assertThatThrownBy(() -> new TicketCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}