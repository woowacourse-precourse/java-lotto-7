package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Ranking;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberTest {
    @Test
    void 당첨번호를_입력하기_전에_보너스_번호를_입력하면_오류_발생() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        BonusNumber bonusNumber = new BonusNumber(10, new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        //when & then
        assertThatThrownBy(() -> winningNumber.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalStateException.class);
    }

    static Stream<Arguments> rankingTestParameters() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Ranking.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 10)), Ranking.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 16)), Ranking.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 15, 16)), Ranking.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 14, 15, 16)), Ranking.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 13, 14, 15, 17)), Ranking.NONE),
                Arguments.of(new Lotto(List.of(1, 2, 13, 14, 15, 17)), Ranking.NONE),
                Arguments.of(new Lotto(List.of(1, 12, 13, 14, 15, 17)), Ranking.NONE),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 17)), Ranking.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("rankingTestParameters")
    void 당첨번호와_비교해서_등수_반환(Lotto lotto, Ranking expected) {
        //given
        WinningNumber winningNumber = new WinningNumber();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.setWinningNumbers(winningLotto);
        winningNumber.setBonusNumber(new BonusNumber(10, winningLotto));

        //when
        Ranking rank = winningNumber.getRanking(lotto);

        //then
        assertEquals(expected, rank);
    }
}
