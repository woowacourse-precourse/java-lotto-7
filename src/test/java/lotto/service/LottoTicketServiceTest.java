package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoPurchasePrice;
import lotto.model.LottoTicketCount;
import lotto.service.generator.RandomTicketNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("LottoTicketService 기능 테스트")
class LottoTicketServiceTest {
    private final LottoTicketService lottoTicketService = new LottoTicketService(new RandomTicketNumberGenerator());

    @DisplayName("로또 구입금액에 해당하는 만큼의 로또 구매 개수를 계산한다.")
    @Test
    void calculateLottoTicketCountByPurchasePrice() {
        // given
        LottoPurchasePrice purchaseAmount = new LottoPurchasePrice(5000);

        // when
        int ticketCount = lottoTicketService.calculateLottoTicketCount(purchaseAmount).ticketCount();

        // then
        assertEquals(5, ticketCount);
    }

    @DisplayName("로또 구매 개수만큼 로또를 발행해야 한다.")
    @Test
    void generateLottosForTicketCount() {
        // given
        LottoTicketCount ticketCount = new LottoTicketCount(3);

        // when
        List<Lotto> generatedLottos = lottoTicketService.generateLottos(ticketCount);

        // then
        assertEquals(ticketCount.ticketCount(), generatedLottos.size());
    }
}