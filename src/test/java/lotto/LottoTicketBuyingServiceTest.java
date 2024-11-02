package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.service.LottoTicketBuyingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketBuyingServiceTest {
    @DisplayName("사용자의 구입 금액에 맞는 갯수의 로또를 발행한다")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "5000", "10000", "15000", "2000", "3000"})
    void 사용자의_구입금액에_맞는_갯수의_로또를_발행한다(String buyingPrice) {
        int expectedTicketAmount = Integer.parseInt(buyingPrice) / 1000;
        int actualTicketCount = LottoTicketBuyingService.buyingLottoTicket(buyingPrice);

        assertThat(expectedTicketAmount).isEqualTo(actualTicketCount);
    }
}
