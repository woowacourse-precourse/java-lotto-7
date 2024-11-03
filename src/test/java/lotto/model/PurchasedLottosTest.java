package lotto.model;

import java.util.List;
import lotto.util.FixedNumbersGenerator;
import lotto.util.NumbersGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottosTest {

    private NumbersGenerator numbersGenerator;

    @BeforeEach
    void beforeEach() {
        this.numbersGenerator = new FixedNumbersGenerator();
    }

    @Test
    @DisplayName("로또 구매 테스트")
    void 로또_구매_테스트() {
        int purchaseCount = 3;
        PurchasedLottos lottos = PurchasedLottos.purchase(purchaseCount, numbersGenerator);

        List<Lotto> purchasedLottos = lottos.getLottos();

        purchasedLottos.forEach(lotto -> Assertions.assertEquals("[1, 2, 3, 4, 5, 6]", lotto.toString()));

    }

    @Test
    void getLottos() {
    }
}
