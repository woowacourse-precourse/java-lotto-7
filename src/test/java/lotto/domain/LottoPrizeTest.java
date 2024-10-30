package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPrizeTest {
    @ParameterizedTest
    @MethodSource("getLottoPrize")
    void getLottoPrize(int matches, int bonus, LottoPrize expected) {
        LottoPrize prize = LottoPrize.getPrize(matches, bonus);

        assertThat(prize).isEqualTo(expected);
    }

    private static Stream<Arguments> getLottoPrize() {
        return Stream.of(
                Arguments.of(6, 0, LottoPrize.FIRST),
                Arguments.of(5, 1, LottoPrize.SECOND),
                Arguments.of(5, 0, LottoPrize.THIRD),
                Arguments.of(4, 0, LottoPrize.FOURTH),
                Arguments.of(3, 0, LottoPrize.FIFTH),
                // 보너스 점수가 있을 경우라도 매칭된다.
                Arguments.of(6, 1, LottoPrize.FIRST),
                Arguments.of(4, 1, LottoPrize.FOURTH),
                Arguments.of(3, 1, LottoPrize.FIFTH),
                // 만족하는 게 없을 경우 None을 반환한다
                Arguments.of(2, 1, LottoPrize.NONE),
                Arguments.of(1, 0, LottoPrize.NONE)
        );
    }
}