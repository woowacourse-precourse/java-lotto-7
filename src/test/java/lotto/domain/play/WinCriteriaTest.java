package lotto.domain.play;

import lotto.domain.rule.PrizeRank;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinCriteriaTest {
    @DisplayName("당첨번호와 보너스 번호에 중복이 있으면 IllegalArgumentException을 반환")
    @Test
    void testThrowIllegalArgumentExceptionWhenDuplicate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber duplicate = LottoNumber.of(1);

        assertThatThrownBy(() -> new WinCriteria(lotto, duplicate))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 보너스 번호에 맞는 PrizeEnum을 반환")
    @ParameterizedTest
    @MethodSource("generateLottoWinData")
    void testFindPrize(Lotto target, PrizeRank expected) {
        Lotto win = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = LottoNumber.of(7);
        WinCriteria winCriteria = new WinCriteria(win, bonus);

        PrizeRank actual = winCriteria.findPrize(target);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> generateLottoWinData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), PrizeRank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), PrizeRank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), PrizeRank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 15, 16)), PrizeRank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 15, 7)), PrizeRank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 14, 15, 16)), PrizeRank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 14, 15, 7)), PrizeRank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 13, 14, 15, 16)), PrizeRank.LOSE),
                Arguments.of(new Lotto(List.of(1, 2, 13, 14, 15, 7)), PrizeRank.LOSE)
        );
    }
}