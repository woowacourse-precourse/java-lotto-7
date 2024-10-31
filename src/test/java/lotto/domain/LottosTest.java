package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.FakeRandomNumber.FakeLottoNumberGenerator;
import lotto.domain.random.CreateRandomNumbers;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class LottosTest {

    private final CreateRandomNumbers createRandomNumbers = new FakeLottoNumberGenerator();

    @Test
    void 로또_리스트를_생성한다() {
        // given
        int lottoCount = 3;
        Lottos lottos = new Lottos(createRandomNumbers, lottoCount);

        // when
        List<Lotto> displayLottos = lottos.displayLottos();

        // then
        assertThat(displayLottos).hasSize(lottoCount);
    }
}
