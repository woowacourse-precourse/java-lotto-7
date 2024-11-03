package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStatisticsTest {
    LottoStatistics lottoStatistics;

    private static Stream<Arguments> provideRanksTestCases() {
        return Stream.of(
                Arguments.of(Rank.FIRST),
                Arguments.of(Rank.SECOND),
                Arguments.of(Rank.THIRD),
                Arguments.of(Rank.FOURTH),
                Arguments.of(Rank.FIFTH)
        );
    }

    @BeforeEach
    void setUp() {
        lottoStatistics = LottoStatistics.createLottoStatistics();
    }

    @DisplayName("로또 통계 객체를 생성하면 모든 등수의 횟수가 0이어야 한다.")
    @Test
    void 로또_통계_객체를_생성하면_모든_등수의_횟수가_0이어야_한다() {
        Map<Rank, Integer> statistics = lottoStatistics.getStatistics();

        for (Rank rank : Rank.values()) {
            assertThat(statistics.get(rank))
                    .isEqualTo(0);
        }
    }

    @DisplayName("로또 통계 객체를 생성하면 상금의 합이 0이어야 한다.")
    @Test
    void 로또_통계_객체를_생성하면_상금의_합이_0이어야_한다() {
        int totalPrize = lottoStatistics.getTotalPrize();

        assertThat(totalPrize)
                .isEqualTo(0);
    }

    @DisplayName("로또의결과를 성공적으로 등록해야한다.")
    @MethodSource("provideRanksTestCases")
    @ParameterizedTest(name = "입력 등수: \"{0}\"")
    void 로또의_결과를_성공적으로_등록해야한다(Rank rank) {
        lottoStatistics.addResult(rank);
        Map<Rank, Integer> statistics = lottoStatistics.getStatistics();
        int totalPrize = lottoStatistics.getTotalPrize();
        int expectedTotalPrize = calculateExpectedTotalPrize(statistics);

        assertThat(statistics.get(rank))
                .isEqualTo(1);
        assertThat(totalPrize)
                .isEqualTo(expectedTotalPrize);
    }

    private int calculateExpectedTotalPrize(Map<Rank, Integer> statistics) {
        return statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
