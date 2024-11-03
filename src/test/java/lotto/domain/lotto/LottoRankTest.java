package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 등수 테스트")
class LottoRankTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("로또 등수를 확인한다")
    void 성공_로또등수확인(int matchingCount, boolean isBonus, LottoRank expected) {
        // Given

        // When
        Optional<LottoRank> rank = LottoRank.findRank(matchingCount, isBonus);

        // Then
        assertThat(rank.get()).isEqualTo(expected);
    }

    private static Stream<Arguments> 성공_로또등수확인() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(3, false, LottoRank.FIFTH)
        );
    }
}
