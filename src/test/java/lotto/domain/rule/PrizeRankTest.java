package lotto.domain.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeRankTest {
    @DisplayName("일치하는 숫자와 보너스 번호 일치 여부에 따라 Prize를 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("generateLottoMatchCountPrize")
    void find(int matchCount, boolean requireBonus, PrizeRank expected) {
        PrizeRank actual = PrizeRank.find(matchCount, requireBonus);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> generateLottoMatchCountPrize() {
        return Stream.of(
                Arguments.of(6, false, PrizeRank.FIRST),
                Arguments.of(6, true, PrizeRank.FIRST),
                Arguments.of(5, true, PrizeRank.SECOND),
                Arguments.of(5, false, PrizeRank.THIRD),
                Arguments.of(4, false, PrizeRank.FOURTH),
                Arguments.of(4, true, PrizeRank.FOURTH),
                Arguments.of(3, false, PrizeRank.FIFTH),
                Arguments.of(3, true, PrizeRank.FIFTH),
                Arguments.of(2, false, PrizeRank.LOSE),
                Arguments.of(2, true, PrizeRank.LOSE),
                Arguments.of(1, false, PrizeRank.LOSE),
                Arguments.of(1, true, PrizeRank.LOSE),
                Arguments.of(0, false, PrizeRank.LOSE),
                Arguments.of(0, true, PrizeRank.LOSE)
        );
    }
}