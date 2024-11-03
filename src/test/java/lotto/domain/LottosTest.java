package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @DisplayName("입력된 금액만큼 로또를 발행한다.")
    @Test
    void 입력된_금액만큼_로또를_발행한다() {
        // given
        Amount amount = new Amount(5000);

        // when
        Lottos lottos = new Lottos(amount);

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}
