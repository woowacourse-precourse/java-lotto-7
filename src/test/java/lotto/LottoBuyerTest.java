package lotto;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoBuyerTest {
    @Test
    void 발행된_로또와_구입_금액을_가진_객체가_만들어진다() {
        //given
        final PurchaseAmount purchaseAmount = new PurchaseAmount("10000");
        final List<Lotto> lottos = LottoPublisher.publishLotto(purchaseAmount);

        //when & then
        assertDoesNotThrow(() -> new LottoBuyer(lottos, purchaseAmount));
    }

    @Test
    void 소비자_객체는_로또_개수와_구입_금액을_반환할_수_있다() {
        //given
        final int expectedLottoCount = 10;
        final int expectedBalance = 10000;

        final PurchaseAmount purchaseAmount = new PurchaseAmount("10000");
        final List<Lotto> lottos = LottoPublisher.publishLotto(purchaseAmount);
        final LottoBuyer lottoBuyer = new LottoBuyer(lottos, purchaseAmount);

        //when
        int lottoCount = lottoBuyer.getLottoCount();
        int balance = lottoBuyer.getPurchaseAmount();

        //then
        assertThat(lottoCount).isEqualTo(expectedLottoCount);
        assertThat(balance).isEqualTo(expectedBalance);
    }
}