package lotto.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @ParameterizedTest(name = "{index}: {3}")
    @MethodSource("lottoRankTestData")
    @DisplayName("로또 번호 매칭 횟수에 따른 등수 반환 테스트")
    void 로또_번호_매칭_횟수에_따른_등수_반환_테스트(int matchingCount, boolean isBonusNumberMatched, LottoRank expectedRank,
                                   String name) {
        Assertions.assertEquals(expectedRank, LottoRank.rankFrom(matchingCount, isBonusNumberMatched));
    }

    private static Stream<Arguments> lottoRankTestData() {
        return Stream.of(
                Arguments.of(6, true, LottoRank.FIRST, "1등 테스트1"),
                Arguments.of(6, false, LottoRank.FIRST, "1등 테스트2"),
                Arguments.of(5, true, LottoRank.SECOND, "2등 테스트"),
                Arguments.of(5, false, LottoRank.THIRD, "3등 테스트"),
                Arguments.of(4, true, LottoRank.FOURTH, "4등 테스트1"),
                Arguments.of(4, false, LottoRank.FOURTH, "4등 테스트2"),
                Arguments.of(3, true, LottoRank.FIFTH, "5등 테스트1"),
                Arguments.of(3, false, LottoRank.FIFTH, "5등 테스트2"),
                Arguments.of(2, true, LottoRank.NONE, "순위권 이외 테스트1"),
                Arguments.of(2, false, LottoRank.NONE, "순위권 이외 테스트2"),
                Arguments.of(1, true, LottoRank.NONE, "순위권 이외 테스트3"),
                Arguments.of(1, false, LottoRank.NONE, "순위권 이외 테스트4"),
                Arguments.of(0, true, LottoRank.NONE, "순위권 이외 테스트5"),
                Arguments.of(0, false, LottoRank.NONE, "순위권 이외 테스트6")
        );
    }

}
