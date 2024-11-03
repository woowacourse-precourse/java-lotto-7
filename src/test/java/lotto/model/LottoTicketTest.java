package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.LottoStatus;
import lotto.dto.LottoTicketStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketTest {

    @DisplayName("로또 티켓의 상태를 요청할 경우 보유중인 로또 갯수에 맞는 로또상태를 가진 티켓 상태를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "20000, 20", "100000, 100"})
    void getLottoTicketStatus(int purchaseAmount, int expected) {
        //given
        LottoTicket lottoTicket = LottoStore.purchaseLottoTicket(purchaseAmount);
        //when
        LottoTicketStatus lottoTicketStatus = lottoTicket.getLottoTicketStatus();
        List<LottoStatus> lottoStatuses = lottoTicketStatus.getLottoStatuses();

        //then
        assertThat(lottoStatuses.size()).isEqualTo(expected);
    }
}