package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class TicketVendorTest {

    @Test
    void 구매_금액의_천을_나눴을_때_로또티켓_수_리턴() {
        // given
        Integer money = 10000;

        // when
        int ticketCount = TicketVendor.vendor(money);

        // then
        assertThat(ticketCount).isEqualTo(10);
    }
}
