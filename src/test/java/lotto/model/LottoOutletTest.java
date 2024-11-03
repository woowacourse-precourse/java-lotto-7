package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.dto.LottoBundle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoOutletTest {

    @DisplayName("입력된 티켓 개수만큼 로또 번호 티켓이 생성되는지 확인한다.")
    @Test
    void Given_TotalTickets_When_GenerateLottoNumbersTicket_Then_LottoTicketWithCorrectSize() {
        int lottoAmount = 3000;
        int expectedCount = lottoAmount / 1000;
        // When
        LottoTicket lottoTicket = LottoOutlet.purchaseLottoTickets(lottoAmount);
        LottoBundle lottoBundle = lottoTicket.getLottoBundle();
        // Then
        assertThat(lottoBundle.getLottoNumbers().size()).isEqualTo(expectedCount);
    }
}