package lotto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTicketbundleTest {

    @Test
    void 티켓_수가_정확한지_테스트() {
        // given
        int ticketCount = 3;

        // when
        List<LottoTicket> lottoTicketBundle = LottoTicketBundle.getLottoTicketBundle(ticketCount);

        // then
        assertThat(lottoTicketBundle).hasSize(ticketCount);
    }

    @Test
    void 티켓_번호가_6개인지_테스트() {
        // given
        int ticketCount = 3;

        // when
        List<LottoTicket> lottoTicketBundle = LottoTicketBundle.getLottoTicketBundle(ticketCount);

        // then
        assertThat(lottoTicketBundle).map(LottoTicket::getNumbers).allMatch(it -> it.size() == 6);
    }
}
