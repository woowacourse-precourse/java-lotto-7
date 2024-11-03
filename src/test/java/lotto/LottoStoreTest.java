package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoStoreTest {
    private final LottoStore lottoStore = new LottoStore();

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1500, 2200, 1100})
    void validatePurchaseAmount(int amount) {
        assertThatThrownBy(() -> lottoStore.buyLottos(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다")
    @Test
    void validateMinimumAmount() {
        assertThatThrownBy(() -> lottoStore.buyLottos(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.");
    }

    @DisplayName("구입 금액에 맞는 개수의 로또를 발행한다")
    @Test
    void buyCorrectNumberOfLottos() {
        List<Lotto> lottos = lottoStore.buyLottos(5000);
        assertThat(lottos).hasSize(5);
    }
}