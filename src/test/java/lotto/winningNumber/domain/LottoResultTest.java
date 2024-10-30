package lotto.winningNumber.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @ParameterizedTest
    @DisplayName("matchedCount와 bonus를 통해 Lottery를 가져올 수 있다")
    @MethodSource("provideLottery")
    void getLottery(int count, boolean bonus, LottoResult lottoResult) throws Exception {
        // given

        // when
        LottoResult lottoResultResult = LottoResult.getLotteryResult(count, bonus);

        // then
        assertThat(lottoResultResult).isEqualTo(lottoResult);
    }

    private static Stream<Arguments> provideLottery() {
        return Stream.of(
                Arguments.arguments(6, true, LottoResult.SIX),
                Arguments.arguments(6, false, LottoResult.SIX),
                Arguments.arguments(5, true, LottoResult.FIVE_BONUS),
                Arguments.arguments(5, false, LottoResult.FIVE),
                Arguments.arguments(4, false, LottoResult.FOUR),
                Arguments.arguments(3, true, LottoResult.THREE),
                Arguments.arguments(2, true, LottoResult.NONE),
                Arguments.arguments(0, true, LottoResult.NONE)
        );
    }

}