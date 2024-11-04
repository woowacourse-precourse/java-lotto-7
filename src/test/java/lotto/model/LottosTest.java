package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.util.FixedRandomNumbers;

class LottosTest {
    private FixedRandomNumbers fixedRandomNumbers;

    @ParameterizedTest
    @DisplayName("Lottos 객체를 생성할 수 있다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void canCreateLottos(int attemptCount) {
        // given
        fixedRandomNumbers = new FixedRandomNumbers();

        // when
        Lottos lottos = Lottos.of(attemptCount, fixedRandomNumbers);

        // then
        assertThat(lottos.getLottos()).hasSize(attemptCount);
    }


    @ParameterizedTest
    @DisplayName("복권을 정상적으로 생성한다.")
    @ValueSource(ints = {1, 5, 10})
    void generateLottosSuccessfully(int attemptCount) {
        // given
        fixedRandomNumbers = new FixedRandomNumbers();

        // when
        Lottos lottos = Lottos.of(attemptCount, fixedRandomNumbers);

        // then
        assertThat(lottos.getLottos().get(0).getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
