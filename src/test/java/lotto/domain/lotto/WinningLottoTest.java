package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.constant.Rank;

@DisplayName("당첨 로또는")
class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("duplicatedWinningNumbersAndBonusNumber")
    void 보너스_번호가_당첨_번호와_중복될_경우_예외를_반환한다(List<Integer> winningNumbers, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setupLotto(new Lotto(winningNumbers));
        assertThatThrownBy(() -> winningLotto.setupBonusNumber(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> duplicatedWinningNumbersAndBonusNumber() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 1),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 2),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 3),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 4),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 5),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("calculateRank")
    void 당첨_순위를_올바르게_계산한다(List<Integer> winningNumbers, List<Integer> numbers, int bonusNumber, Rank result) {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setupLotto(new Lotto(winningNumbers));
        winningLotto.setupBonusNumber(bonusNumber);
        Lotto lotto = new Lotto(numbers);
        assertThat(winningLotto.getRank(lotto)).isEqualTo(result);
    }

    private static Stream<Arguments> calculateRank() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, Rank.FIRST),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7), 7, Rank.SECOND),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 9), 7, Rank.THIRD),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 9, 10), 7, Rank.FOURTH),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 9, 10, 11), 7, Rank.FIFTH)
        );
    }
}
