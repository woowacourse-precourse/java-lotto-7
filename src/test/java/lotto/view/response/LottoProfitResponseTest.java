package lotto.view.response;

import lotto.model.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoProfitResponse 테스트")
public class LottoProfitResponseTest {

    static Stream<Arguments> 점수_리스트와_구매_금액을_받아_생성된다_테스트_케이스() {
        return Stream.of(
                makeArguments(List.of(Score.ZERO), 1000),
                makeArguments(List.of(Score.THREE, Score.FIFTH), 2000),
                makeArguments(List.of(Score.FIFTH_WITH_BONUS, Score.ZERO, Score.ZERO), 3000),
                makeArguments(List.of(Score.FIFTH, Score.FOURTH, Score.THREE), 3000),
                makeArguments(List.of(Score.FIFTH, Score.ZERO, Score.FIFTH), 3000),
                makeArguments(List.of(Score.ZERO, Score.ZERO, Score.ZERO), 3000),
                makeArguments(List.of(Score.FIFTH, Score.FIFTH_WITH_BONUS, Score.ZERO), 3000)
        );
    }

    static Arguments makeArguments(List<Score> scores, int purchaseMoney) {
        double profitRate = (double) scores.stream().mapToInt(Score::getPrize).sum() / purchaseMoney * 100;
        return Arguments.of(scores, purchaseMoney, profitRate);
    }

    @ParameterizedTest(name = "scores: {0}, purchaseMoney: {1}, expected: {2}")
    @MethodSource("점수_리스트와_구매_금액을_받아_생성된다_테스트_케이스")
    void 로또_점수_리스트와_구매_금액을_받아_생성된다(List<Score> scores, int purchaseMoney, double expected) {

        // when
        LottoProfitResponse lottoProfitResponse = LottoProfitResponse.of(scores, purchaseMoney);
        double actual = lottoProfitResponse.getProfitRate();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
