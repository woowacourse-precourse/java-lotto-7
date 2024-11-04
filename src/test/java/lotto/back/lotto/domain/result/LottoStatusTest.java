package lotto.back.lotto.domain.result;

import java.util.stream.Stream;
import lotto.global.status.LottoStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStatusTest {

    @ParameterizedTest()
    @MethodSource("prizeCheckSource")
    void 당첨_상태_구하기(Integer matchCount, Boolean bonusMatched, LottoStatus expectedLottoStatus) {
        // when
        LottoStatus lottoStatus = LottoStatus.getResult(matchCount, bonusMatched);

        // then
        Assertions.assertThat(lottoStatus).isEqualTo(expectedLottoStatus);
    }

    // given
    private static Stream<Arguments> prizeCheckSource() {
        return Stream.of(
                Arguments.of(6, true, LottoStatus.FIRST),
                Arguments.of(5, true, LottoStatus.SECOND),
                Arguments.of(5, false, LottoStatus.THIRD),
                Arguments.of(4, true, LottoStatus.FOURTH),
                Arguments.of(3, true, LottoStatus.FIFTH),
                Arguments.of(2, true, LottoStatus.NONE),
                Arguments.of(1, true, LottoStatus.NONE),
                Arguments.of(0, true, LottoStatus.NONE)
        );
    }

}