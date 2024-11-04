package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class LottosTest {
    private static final int LOTTO_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    @DisplayName("로또 수량만큼 로또가 생성된다.")
    @Test
    void createLottosByCount() {
        // given
        long count = 5;

        // when
        Lottos lottos = Lottos.autoGenerate(count);

        // then
        assertThat(lottos.getSize()).isEqualTo(5);
    }

    @DisplayName("로또 목록은 불변이어야 한다.")
    @Test
    void validateLottosImmutability() {
        // given
        Lottos lottos = Lottos.autoGenerate(1);
        List<Lotto> generatedLottos = lottos.getLottos();

        // when & then
        assertThatThrownBy(() -> generatedLottos.add(Lotto.auto()))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("복수의 로또를 정상적으로 생성한다.")
    @Test
    void createMultipleLottos() {
        // given
        long count = 3;

        // when
        Lottos lottos = Lottos.autoGenerate(count);
        List<Lotto> generatedLottos = lottos.getLottos();

        // then
        assertThat(generatedLottos).hasSize(3);
        assertThat(generatedLottos)
                .allMatch(lotto -> lotto.getNumbers().size() == LOTTO_SIZE)
                .allMatch(lotto -> new HashSet<>(lotto.getNumbers()).size() == LOTTO_SIZE)
                .allMatch(lotto -> lotto.getNumbers().stream()
                        .allMatch(number -> number >= MINIMUM_LOTTO_NUMBER
                                && number <= MAXIMUM_LOTTO_NUMBER));
    }
}

