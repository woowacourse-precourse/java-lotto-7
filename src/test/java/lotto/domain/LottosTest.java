package lotto.domain;

import static lotto.constant.NumberType.LOTTO_PRICE_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @Test
    @DisplayName("from - 정확한 개수 만큼 로또를 만든다.")
    void makeLottosWithExactCount() {
        // given
        int count = 10;
        // when
        Lottos lottos = Lottos.from(count);
        List<Lotto> lottosList = lottos.getLottos();
        // then
        assertThat(lottosList.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("from - 정확한 개수 만큼 산 금액을 정확히 저장한다.")
    void makeLottosWithExactMoney() {
        // given
        int count = 10;
        // when
        Lottos lottos = Lottos.from(count);
        // then
        assertThat(lottos.getPrice()).isEqualTo(count * LOTTO_PRICE_UNIT.getNumber());
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    @DisplayName("from - 개수를 1개 미만으로 하면 예외가 발생한다.")
    void failMakeLottosWithInvalidCount(int count) {
        assertThatThrownBy(() -> Lottos.from(count))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_COUNT.getMessage());
    }
}

