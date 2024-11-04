package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.global.util.LottoMachine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void 객체생성_테스트(int count) {
        Lottos lottos = Lottos.from(LottoMachine.generate(count));

        assertThat(lottos).isNotNull();
        assertThat(lottos.getLottos().size()).isEqualTo(count);
    }
}
