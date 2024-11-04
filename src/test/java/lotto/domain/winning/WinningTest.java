package lotto.domain.winning;

import static lotto.constant.Error.DUPLICATED_WINNING_BONUS_NUMBERS;
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
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningTest {

    @ParameterizedTest
    @MethodSource("provideLottos")
    void 로또의_랭킹을_매길_수_있다(Lotto lotto, Rank expected) throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 9, 18, 27, 36, 45));
        BonusNumber bonusNumber = new BonusNumber(7);
        Winning winning = new Winning(winningNumbers, bonusNumber);

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

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        assertThatThrownBy(() -> new Winning(winningNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(DUPLICATED_WINNING_BONUS_NUMBERS);
    }

}