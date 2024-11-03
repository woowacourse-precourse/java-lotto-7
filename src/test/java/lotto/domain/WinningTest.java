package lotto.domain;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningTest {

    @DisplayName("로또 티켓의 등수를 매길 수 있다.")
    @ParameterizedTest
    @MethodSource("provideLottos")
    void 로또_티켓의_등수를_매길_수_있다(Lotto lotto, Rank expected) throws Exception {
        Winning winning = new Winning(List.of(1, 9, 18, 27, 36, 45), 7);

        Rank rank = winning.rank(lotto);

        assertThat(rank).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottos() {
        return Stream.of(
            Arguments.of(new Lotto(List.of(1, 9, 18, 27, 36, 45)), FIRST),
            Arguments.of(new Lotto(List.of(7, 9, 18, 27, 36, 45)), SECOND),
            Arguments.of(new Lotto(List.of(2, 9, 18, 27, 36, 45)), THIRD),
            Arguments.of(new Lotto(List.of(7, 3, 18, 27, 36, 45)), FOURTH),
            Arguments.of(new Lotto(List.of(7, 3, 4, 27, 36, 45)), FIFTH),
            Arguments.of(new Lotto(List.of(7, 3, 4, 5, 36, 45)), DRAW),
            Arguments.of(new Lotto(List.of(7, 3, 4, 5, 6, 45)), DRAW),
            Arguments.of(new Lotto(List.of(2, 3, 4, 5, 7, 45)), DRAW)
        );
    }
}