package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
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

    @DisplayName("구매한 로또 하나와 당첨 로또를 비교한다.")
    @ParameterizedTest
    @MethodSource("provideWiningLottoAndBonusAndRank")
    void 구매한_로또_하나와_당첨_로또를_비교한다(List<Integer> winningLotto, int bonusNumber, Rank expectedRank) {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Rank rank = userLotto.calculateRanks(winningLotto, bonusNumber);

        assertThat(rank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> provideWiningLottoAndBonusAndRank() {
        return Stream.of(
                Arguments.of(List.of(4, 5, 6, 1, 2, 3), 8, Rank.FIRST),
                Arguments.of(List.of(4, 5, 7, 1, 2, 3), 6, Rank.SECOND),
                Arguments.of(List.of(4, 5, 7, 1, 2, 3), 8, Rank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), 9, Rank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 10, Rank.FIFTH),
                Arguments.of(List.of(7, 8, 9, 10, 5, 6), 8, Rank.NONE)
        );
    }
}
