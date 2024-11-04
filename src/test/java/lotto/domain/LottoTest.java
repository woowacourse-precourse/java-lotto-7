package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideOutRangeCase")
    void 로또_번호가_1_45_범위를_벗어나면_예외가_발생(List<Integer> lotto) {
        assertThatThrownBy(() -> new Lotto(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> provideOutRangeCase() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 46),
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 47, 5),
                List.of(-1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 당첨_번호와_일치하는_번호_개수_정확히_계산() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(List.of(1, 2, 3, 11, 22, 33));
        assertThat(lotto.countMatchNumbers(winning)).isEqualTo(3);
    }

    @Test
    void 유효한_로또번호_객체_생성() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatNoException().isThrownBy(() -> new Lotto(validNumbers));
    }
}
