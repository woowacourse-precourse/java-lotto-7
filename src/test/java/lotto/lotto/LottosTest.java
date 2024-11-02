package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 로또를_발행한다() {
        // given
        LottoAmount lottoAmount = new LottoAmount(3000);

        // when
        Lottos lottos = Lottos.purchase(lottoAmount, new StubLottoGenerator());

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(3);
    }

    static class StubLottoGenerator implements NumberGenerator {

        @Override
        public List<Integer> generate() {
            return Arrays.asList(1, 2, 3, 4, 5, 6);
        }
    }
}
