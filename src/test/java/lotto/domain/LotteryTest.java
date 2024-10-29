package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LotteryTest {

    @ParameterizedTest
    @DisplayName("matchedCount와 bonus를 통해 Lottery를 가져올 수 있다")
    @MethodSource("provideLottery")
    void getLottery(int count, boolean bonus, Lottery lottery) throws Exception {
        // given

        // when
        Lottery lotteryResult = Lottery.getLotteryResult(count, bonus);

        // then
        assertThat(lotteryResult).isEqualTo(lottery);
    }

    private static Stream<Arguments> provideLottery() {
        return Stream.of(
                Arguments.arguments(6, true, Lottery.SIX),
                Arguments.arguments(6, false, Lottery.SIX),
                Arguments.arguments(5, true, Lottery.FIVE_BONUS),
                Arguments.arguments(5, false, Lottery.FIVE),
                Arguments.arguments(4, false, Lottery.FOUR),
                Arguments.arguments(3, true, Lottery.THREE),
                Arguments.arguments(2, true, Lottery.NONE),
                Arguments.arguments(0, true, Lottery.NONE)
        );
    }

}