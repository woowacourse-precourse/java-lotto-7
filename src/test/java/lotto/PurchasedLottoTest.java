package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottoTest {
    @DisplayName("1000원당 로또 1장을 발행한다.")
    @Test
    void 천원당_로또_한장을_발행한다() {
        validateLottoCount("1000", 1);
        validateLottoCount("2000", 2);
        validateLottoCount("5000", 5);
    }

    void validateLottoCount(String paymentAmount, int expectedCount) {
        Payment payment = Payment.from(paymentAmount);
        PurchasedLotto purchasedLotto = PurchasedLotto.from(payment);
        assertEquals(expectedCount, purchasedLotto.getCount());
    }
}
