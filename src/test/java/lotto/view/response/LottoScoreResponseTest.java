package lotto.view.response;

import lotto.model.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoScoreResponse 테스트")
public class LottoScoreResponseTest {

    static Stream<Arguments> 로또_점수_객체로부터_생성된다_테스트_케이스() {
        return Stream.of(
                makeArguments(Score.ZERO),
                makeArguments(Score.THREE),
                makeArguments(Score.FIFTH),
                makeArguments(Score.FIFTH_WITH_BONUS),
                makeArguments(Score.FOURTH)
        );
    }

    static Arguments makeArguments(Score score) {
        return Arguments.of(score, score.getMatchCount(), score.containsBonus(), score.getPrize());
    }

    @ParameterizedTest(name = "score: {0}, expectedMatchCount: {1}, expectedContainsBonus: {2}, expectedPrize: {3}")
    @MethodSource("로또_점수_객체로부터_생성된다_테스트_케이스")
    void 로또_점수_객체로부터_생성된다(Score score, int expectedMatchCount, boolean expectedContainsBonus, int expectedPrize) {

        // when
        LottoScoreResponse lottoScoreResponse = LottoScoreResponse.from(score);
        int actualMatchCount = lottoScoreResponse.getMatchCount();
        boolean actualContainsBonus = lottoScoreResponse.containsBonus();
        int actualPrize = lottoScoreResponse.getPrize();

        // then
        assertThat(actualMatchCount).isEqualTo(expectedMatchCount);
        assertThat(actualContainsBonus).isEqualTo(expectedContainsBonus);
        assertThat(actualPrize).isEqualTo(expectedPrize);
    }
}
