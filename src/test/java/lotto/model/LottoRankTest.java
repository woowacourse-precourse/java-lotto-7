package lotto.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("lottoRankTestData")
    @DisplayName("로또 번호 매칭 횟수에 따른 등수 반환 테스트")
    void 로또_번호_매칭_횟수에_따른_등수_반환_테스트(int matchingCount, boolean isBonusNumberMatched, LottoRank expectedRank) {
        Assertions.assertEquals(expectedRank, LottoRank.rankFrom(matchingCount, isBonusNumberMatched));
    }

    private static Stream<Arguments> lottoRankTestData() {
        return Stream.of(
                Arguments.of(6, true, LottoRank.FIRST),
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(2, true, LottoRank.NONE),
                Arguments.of(2, false, LottoRank.NONE),
                Arguments.of(1, true, LottoRank.NONE),
                Arguments.of(1, false, LottoRank.NONE),
                Arguments.of(0, true, LottoRank.NONE),
                Arguments.of(0, false, LottoRank.NONE)
        );
    }

}
