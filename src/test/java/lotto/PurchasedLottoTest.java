package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottoTest {

    @DisplayName("1000원당 로또 1장을 발행한다.")
    @Test
    void 천원당_로또_한장을_발행한다() {
        Payment payment = Payment.from("1000");
        PurchasedLotto purchasedLotto = PurchasedLotto.from(payment);
        assertEquals(purchasedLotto.getCount(), 1);
    }
}
