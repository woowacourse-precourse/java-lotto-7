package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.dto.LottoBundle;
import lotto.dto.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoOutletTest {
    @DisplayName("올바른 티켓 값이 나오는지 확인한다.")
    @Test
    void Given_LottoAmountIs3000_When_BuyTicketsByAmount_Then_3() {
        // Given
        LottoOutlet lottoOutlet = new LottoOutlet();
        int lottoAmount = 3000;
        // When
        int ticketCount = lottoOutlet.buyTicketsByAmount(lottoAmount);
        // Then
        assertThat(ticketCount).isEqualTo(3);
    }

    @DisplayName("입력된 티켓 개수만큼 로또 번호 티켓이 생성되는지 확인한다.")
    @Test
    void Given_TotalTickets_When_GenerateLottoNumbersTicket_Then_LottoTicketWithCorrectSize() {
        // Given
        int totalTickets = 5;
        // When
        LottoTicket lottoTicket = LottoOutlet.generateLottoNumbersTicket(totalTickets);
        LottoBundle lottoTicketStatus = lottoTicket.getLottoTicketStatus();
        int size = lottoTicketStatus.getLottoNumbers().size();
        // Then
        assertThat(size).isEqualTo(totalTickets);
    }
}