package lotto.domain.winning;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.rank.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnswerNumbersTest {

    AnswerNumbers answerNumbers;

    @BeforeEach
    void setUp() {
        WinningLotto winningLotto = WinningLotto.of(
                List.of(1, 2, 3, 4, 5, 6)
        );

        BonusNumber bonusNumber = BonusNumber.valueOf(
                winningLotto, 7
        );

        answerNumbers = AnswerNumbers.from(
                winningLotto, bonusNumber);
    }

    @DisplayName("객체 생성 테스트")
    @Test
    void 객체생성_테스트() {
        assertThat(answerNumbers).isNotNull();
    }

    @DisplayName("당첨 번호와 로또 번호 비교 테스트")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provide")
    void 비교하기(String title, Lotto lotto, Rank expectedRank) {
        Rank rank = answerNumbers.compare(lotto);

        assertThat(rank).isNotNull();
        assertThat(rank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of("1등",
                        Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                        Rank.FIRST),
                Arguments.of("2등",
                        Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
                        Rank.SECOND),
                Arguments.of("3등",
                        Lotto.of(List.of(1, 2, 3, 4, 5, 8)),
                        Rank.THIRD),
                Arguments.of("4등 보너스 포함",
                        Lotto.of(List.of(1, 2, 3, 4, 7, 8)),
                        Rank.FOURTH),
                Arguments.of("4등 보너스 미포함",
                        Lotto.of(List.of(1, 2, 3, 4, 8, 9)),
                        Rank.FOURTH)
        );
    }
}
