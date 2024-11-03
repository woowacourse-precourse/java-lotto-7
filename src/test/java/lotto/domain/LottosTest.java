package lotto.domain;

import static lotto.constant.NumberType.LOTTO_PRICE_UNIT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("정확한 개수 만큼 로또를 만든다.")
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
    @DisplayName("정확한 개수 만큼 산 금액을 정확히 저장한다.")
    void makeLottosWithExactMoney() {
        // given
        int count = 10;
        // when
        Lottos lottos = Lottos.from(count);
        // then
        assertThat(lottos.getPrice()).isEqualTo(count * LOTTO_PRICE_UNIT.getNumber());
    }
}

