package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {
    @Test
    void 로또가_특정_번호를_포함하면_true를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(1)).isTrue();
    }

    @Test
    void 로또가_번호를_포함하지_않으면_false를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(10)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("matchingCountParameters")
    void 다른_로또_번호와_일치_개수를_올바르게_반환한다(Lotto other, int expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getMatchingCount(other))
                .isEqualTo(expected);
    }

    static Stream<Arguments> matchingCountParameters() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 10)), 5),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 11, 10)), 4),
                Arguments.of(new Lotto(List.of(1, 2, 3, 12, 11, 10)), 3),
                Arguments.of(new Lotto(List.of(1, 2, 13, 14, 15, 16)), 2),
                Arguments.of(new Lotto(List.of(1, 12, 13, 14, 15, 16)), 1),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)), 0)
        );
    }
}
