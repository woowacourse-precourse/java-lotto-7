package lotto.view.response;

import lotto.model.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoScoreResponses 테스트")
public class LottoScoreResponsesTest {

    static Stream<Arguments> 로또_점수_정수_맵을_통해_생성된다_테스트_케이스() {
        return Stream.of(
                makeArguments(Map.of(Score.FOURTH, 1, Score.FIFTH, 1)),
                makeArguments(Map.of(Score.FOURTH, 1, Score.FIFTH, 5, Score.THREE, 1)),
                makeArguments(Map.of(Score.FOURTH, 1, Score.FIFTH, 1, Score.ZERO, 5))
        );
    }

    static Arguments makeArguments(Map<Score, Integer> scores) {
        Map<LottoScoreResponse, Integer> expected = new LinkedHashMap<>();
        scores.forEach((score, count) -> expected.put(LottoScoreResponse.from(score), count));

        return Arguments.of(scores, expected);
    }

    @ParameterizedTest(name = "scores: {0}, expected: {1}")
    @MethodSource("로또_점수_정수_맵을_통해_생성된다_테스트_케이스")
    void 로또_점수_정수_맵을_통해_생성된다(Map<Score, Integer> scores, Map<LottoScoreResponse, Integer> expected) {
        
        // when
        Map<LottoScoreResponse, Integer> actual = LottoScoreResponses.from(scores).getLottoScoreResponses();

        // then
        assertThat(actual).containsExactlyEntriesOf(expected);
    }
}
