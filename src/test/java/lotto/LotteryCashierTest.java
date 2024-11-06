package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.common.Price;
import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("로또 구매를 테스트한다.")
class LotteryCashierTest {

    private final LotteryCashier lotteryCashier = new LotteryCashier();

    @DisplayName("성공 케이스를 테스트한다.")
    @Nested
    class HappyCase {

        @DisplayName("로또를 구매할 수 있으면 성공한다.")
        @Test
        void testLottoPurchase() {
            Price price = new Price(3000);

            Lottos lottos = lotteryCashier.purchaseBy(price);

            assertThat(lottos).isNotNull();
        }
    }
}