package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {
    @Test
    @DisplayName("구매자 Lottos 저장 테스트")
    void testGetLottos() {
        Seller seller = new Seller();
        Buyer buyer = new Buyer(seller.createLottoTickets(8000));

        assertEquals(buyer.getLottos().size(), 8);
    }
}
