package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.mock.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseLottoTest {

    NumberGenerator numberGenerator;
    PurchaseLotto purchaseLotto;

    @BeforeEach
    void setUp() {
        NumberGenerator numberGenerator = new NumberGenerator();
        purchaseLotto = PurchaseLotto.of(new PurchasePrice("3000"), numberGenerator);
    }

    @DisplayName("3000원만 구입했을 때 로또 티켓의 번호 수는 3개이다.")
    @Test
    void testLottoIsGeneratedRandomNumber() {
        int ticketCount = purchaseLotto.getLottoCount();

        assertEquals(3, ticketCount, "3000원으로 구매한 로또 티켓의 개수는 3개이어야 합니다.");
    }

}