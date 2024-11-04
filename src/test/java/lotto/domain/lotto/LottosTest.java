package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Number;
import lotto.domain.lotto.FakeRandomNumber.FakeLottoNumberGenerator;
import lotto.domain.lotto.random.CreateRandomNumbers;
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
        assertThat(displayLottos.getFirst().displayLotto())
                .containsExactly(
                        Number.from(1),
                        Number.from(2),
                        Number.from(3),
                        Number.from(4),
                        Number.from(5),
                        Number.from(6)
                );
    }

    @Test
    void 반환된_로또_리스트는_수정할_수_없다() {
        // given
        int lottoCount = 2;
        Lottos lottos = new Lottos(createRandomNumbers, lottoCount);

        // when
        List<Lotto> displayLottos = lottos.displayLottos();

        // then
        assertThatThrownBy(() -> displayLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
