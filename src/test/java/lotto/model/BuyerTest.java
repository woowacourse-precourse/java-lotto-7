package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Test
    @DisplayName("Lotto에 보너스 번호가 존재하는지 유무 테스트")
    void testHasBonusNumberInMyLotto() {
        Buyer buyer = new Buyer();
        assertThat(buyer.hasBonusNumber(7, new Lotto(List.of(1, 2, 13, 41, 7, 8)))).isTrue();
        assertThat(buyer.hasBonusNumber(15, new Lotto(List.of(1, 2, 13, 41, 7, 8)))).isFalse();
    }

    @Test
    @DisplayName("몇등 당첨 반환 테스트")
    void testGetRank() {
        Buyer buyer = new Buyer();
        assertEquals(buyer.getRank(0, true), Rank.EMPTY_0);
        assertEquals(buyer.getRank(1, true), Rank.EMPTY_1);
        assertEquals(buyer.getRank(2, true), Rank.EMPTY_2);
        assertEquals(buyer.getRank(3, true), Rank.FIFTH);
        assertEquals(buyer.getRank(4, true), Rank.FOURTH);
        assertEquals(buyer.getRank(6, true), Rank.FIRST);
        assertEquals(buyer.getRank(5, true), Rank.SECOND);
        assertEquals(buyer.getRank(5, false), Rank.THIRD);
    }
}
