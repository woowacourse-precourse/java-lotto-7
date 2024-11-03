package lotto;

import lotto.domain.model.Lotto;
import lotto.domain.service.LottoPurchaseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoPurchaseServiceTest {

    @Test
    @DisplayName("티켓_구매_성공")
    void 티켓_구매_성공() {
        LottoPurchaseService purchaseService = new LottoPurchaseService();
        int purchaseAmount = 5000;

        List<Lotto> tickets = purchaseService.purchaseTickets(purchaseAmount);

        assertEquals(5, tickets.size());
    }
}