package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottosTest {
    Lottos lottos;

    @BeforeEach
    void init() {
        lottos = new Lottos();
    }

    @Test
    void 로또_구입_개수를_계산한다() {
        String purchaseAmount = "5000";
        lottos.calculateLottoPurchaseCount(purchaseAmount);

        assertThat(lottos.getLottoPurchaseCount())
                .isEqualTo(5);
    }
}
