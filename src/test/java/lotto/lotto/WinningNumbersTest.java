package lotto.lotto;

import static lotto.lotto.MatchingCondition.FAILURE;
import static lotto.lotto.MatchingCondition.FIVE;
import static lotto.lotto.MatchingCondition.FIVE_AND_BONUS;
import static lotto.lotto.MatchingCondition.FOUR;
import static lotto.lotto.MatchingCondition.SIX;
import static lotto.lotto.MatchingCondition.THREE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("normalLottoCases")
    @DisplayName("구입한 로또의 당첨 결과를 1-5등과 당첨 안됨으로 각각 분류한다")
    void lottoToMatchingCondition(Lottos lottos) {
        // given
        int bonusNumber = 11;
        WinningNumbers winningNumbers = WinningNumbers.of(bonusNumber, "1", "2", "3", "4", "5", "6");

        // when
        List<MatchingCondition> conditions = winningNumbers.matchWinningNumbersTo(lottos);

        // then
        assertThat(conditions).containsExactly(SIX, FIVE_AND_BONUS, FIVE, FOUR, THREE, FAILURE);

    }

    private static Stream<Arguments> normalLottoCases() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 19, 22));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 17, 8, 12));
        Lotto lottoFailure = new Lotto(List.of(1, 2, 33, 34, 35, 36));

        List<Lotto> rawLotto = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lottoFailure);

        Lottos lottos = Lottos.from(rawLotto);

        return Stream.of(
                Arguments.arguments(lottos)
        );
    }
}
