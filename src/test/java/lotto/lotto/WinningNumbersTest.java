package lotto.lotto;

import static lotto.lotto.MatchingCondition.FAILURE;
import static lotto.lotto.MatchingCondition.FIVE;
import static lotto.lotto.MatchingCondition.FIVE_AND_BONUS;
import static lotto.lotto.MatchingCondition.FOUR;
import static lotto.lotto.MatchingCondition.SIX;
import static lotto.lotto.MatchingCondition.THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("normalLottoCases")
    @DisplayName("구입한 로또의 당첨 결과를 1-5등과 당첨 안됨으로 각각 분류한다")
    void lottoToMatchingCondition(Lottos lottos) {
        // given
        BonusNumber bonusNumber = BonusNumber.from(11);
        WinningNumbers winningNumbers = WinningNumbers.of("1", "2", "3", "4", "5", "6");

        // when
        List<MatchingCondition> conditions = winningNumbers.matchWinningNumbersTo(lottos, bonusNumber);

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

    @ParameterizedTest
    @MethodSource("nonIntegerCases")
    @DisplayName("당첨 번호를 표현하는 구분자를 가진 문자열은 적절한 형식이어야 한다")
    void nonIntegerFormatThrowsException(String[] invalid) {
        assertThatThrownBy(() -> WinningNumbers.of(invalid))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호의 형식이 잘못되었습니다.");
    }

    private static Stream<Arguments> nonIntegerCases() {
        String[] rawCase1 = new String[]{"1", "a", "b"};
        String[] rawCase2 = new String[]{"1ab"};
        String[] rawCase3 = new String[]{"df", "a", "b"};
        String[] rawCase4 = new String[]{"ㄱㄴ", "a", "b"};
        String[] rawCase5 = new String[]{"1", "ff", "b"};

        return Stream.of(
                Arguments.arguments((Object) rawCase1),
                Arguments.arguments((Object) rawCase2),
                Arguments.arguments((Object) rawCase3),
                Arguments.arguments((Object) rawCase4),
                Arguments.arguments((Object) rawCase5)
        );
    }

    @Test
    @DisplayName("당첨 번호는 6개여야 한다")
    void notNunOfWinningNumberThrowException() {
        assertThatThrownBy(() -> WinningNumbers.of("1", "2", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }
}
