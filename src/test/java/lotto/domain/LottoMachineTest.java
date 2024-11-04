package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoMachineTest {

    @DisplayName("구매한 로또 티켓 개수만큼 발행 테스트")
    @Test
    void purchaseLottoTicketsTest() {
        int purchaseAmount = 8000;
        int ticketPrice = 1000;

        List<LottoScore> purchasedLotto = LottoMachine.purchaseLottoTickets(purchaseAmount, ticketPrice);
        int expectedTicketCount = purchaseAmount / ticketPrice;
        assertEquals(expectedTicketCount, purchasedLotto.size());
    }
}
