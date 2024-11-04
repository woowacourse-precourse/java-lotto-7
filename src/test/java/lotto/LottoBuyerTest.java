package lotto;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoBuyerTest {
    @Test
    void 발행된_로또와_구입_금액을_가진_객체가_만들어진다() {
        //given (List<Lotto> lottos, PurchaseAmount purchaseAmount)
        final PurchaseAmount purchaseAmount = new PurchaseAmount("10000");
        final List<Lotto> lottos = LottoPublisher.publishLotto(purchaseAmount);

        //when & then
        assertDoesNotThrow(() -> new LottoBuyer(lottos, purchaseAmount));
    }
}