package lotto;

import lotto.Model.PurchaseCost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PurchaseCostTest {
    static PurchaseCost purchaseCost;

    @BeforeEach
    void 구입금액_객체_생성() {
        purchaseCost = new PurchaseCost(8000);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0})
    void 제로_이하의_구입금액은_예외를_발생시킨다(int inputtedCost) {
        assertThatThrownBy(() -> new PurchaseCost(inputtedCost))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
