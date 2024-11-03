package lotto.domain;

import static lotto.domain.Rank.DRAW;
import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningTest {

    @DisplayName("당첨 티켓의 등수를 매길 수 있다.")
    @ParameterizedTest
    @MethodSource("provideLottos")
    void 당첨_티켓의_등수를_매길_수_있다(Lotto lotto, Rank expected) throws Exception {
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

    @DisplayName("당첨 번호의 개수가 6개가 넘으면 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6, 7), 8))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5), 6))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 5), 6))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() throws Exception {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6), 6))
            .isInstanceOf(IllegalArgumentException.class);
    }
}