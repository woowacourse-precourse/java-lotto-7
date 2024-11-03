package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
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

    @Test
    @DisplayName("당첨 복권과 비교해서 몇개가 동일한지 알아보는 테스트")
    void testHowManyCorrectMyLotto() {
        Buyer buyer = new Buyer();
        assertEquals(buyer.getMatchCount(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(40, 39, 38, 37, 36, 1))), 1);
        assertEquals(buyer.getMatchCount(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(40, 39, 38, 37, 2, 1))), 2);
        assertEquals(buyer.getMatchCount(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(40, 39, 38, 3, 2, 1))), 3);
        assertEquals(buyer.getMatchCount(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(40, 39, 4, 3, 2, 1))), 4);
        assertEquals(buyer.getMatchCount(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(40, 5, 4, 3, 2, 1))), 5);
        assertEquals(buyer.getMatchCount(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(6, 5, 4, 3, 2, 1))), 6);
    }
}
