package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoStatisticsTest {

    @ParameterizedTest
    @MethodSource("generateLottoData")
    void 로또_수익률_계산(List<LottoRank> lottoRanks, int investmentMoney, double expectedRateOfResult) {
        // when
        double rateOfResult = LottoStatistics.calcRateOfReturn(investmentMoney, lottoRanks);

        // then
        assertThat(rateOfResult)
                .isEqualTo(expectedRateOfResult);
    }

    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of(List.of(LottoRank.NONE), 8000, 0),
                Arguments.of(List.of(LottoRank.NONE, LottoRank.GRADE_5TH), 8000, 62.5),
                Arguments.of(List.of(LottoRank.GRADE_5TH, LottoRank.GRADE_5TH), 8000, 125),
                Arguments.of(List.of(LottoRank.NONE, LottoRank.GRADE_4TH), 8000, 625),
                Arguments.of(List.of(LottoRank.NONE, LottoRank.GRADE_3TH), 8000, 18750),
                Arguments.of(List.of(LottoRank.NONE, LottoRank.GRADE_2TH), 8000, 375000),
                Arguments.of(List.of(LottoRank.NONE, LottoRank.GRADE_1TH), 8000, 25000000)
        );
    }

    @Test
    void 로또_당첨_등수_통계_계산() {
        // given
        List<LottoRank> lottoRanks = List.of(
                LottoRank.NONE, LottoRank.NONE, LottoRank.NONE, LottoRank.NONE,
                LottoRank.GRADE_5TH, LottoRank.GRADE_5TH, LottoRank.GRADE_5TH, LottoRank.GRADE_5TH,
                LottoRank.GRADE_4TH, LottoRank.GRADE_4TH, LottoRank.GRADE_4TH,
                LottoRank.GRADE_3TH, LottoRank.GRADE_3TH,
                LottoRank.GRADE_1TH
        );

        // when
        Map<LottoRank, Integer> rankMap = LottoStatistics.calcRankStatistics(lottoRanks);

        // then
        assertThat(rankMap.get(LottoRank.NONE))
                .isEqualTo(4);
        assertThat(rankMap.get(LottoRank.GRADE_5TH))
                .isEqualTo(4);
        assertThat(rankMap.get(LottoRank.GRADE_4TH))
                .isEqualTo(3);
        assertThat(rankMap.get(LottoRank.GRADE_3TH))
                .isEqualTo(2);
        assertThat(rankMap.get(LottoRank.GRADE_2TH))
                .isEqualTo(0);
        assertThat(rankMap.get(LottoRank.GRADE_1TH))
                .isEqualTo(1);
    }
}
