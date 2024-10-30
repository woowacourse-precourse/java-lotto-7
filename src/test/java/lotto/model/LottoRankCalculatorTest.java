package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

class LottoRankCalculatorTest {
    @Test
    void 로또_3등_반환_테스트() {
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator();
        assertSimpleTest(() -> {
            assertThat(
                    lottoRankCalculator.getLottoPrizeRank(List.of(1, 2, 3, 4, 5, 46), List.of(1, 2, 13, 4, 5, 46), 8)).isEqualTo(
                    LottoRank.THIRD);
        });
    }

    @Test
    void 로또_0등_반환_테스트() {
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator();
        assertSimpleTest(() -> {
            assertThat(
                    lottoRankCalculator.getLottoPrizeRank(List.of(1, 2, 3, 4, 5, 46), List.of(11, 12, 13, 14, 5, 46), 8)).isEqualTo(
                    LottoRank.NONE);
        });
    }

    @Test
    void 로또_2등_반환_테스트() {
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator();
        assertSimpleTest(() -> {
            assertThat(
                    lottoRankCalculator.getLottoPrizeRank(List.of(1, 2, 3, 4, 8, 46), List.of(1, 2, 3, 4, 5, 46), 8)).isEqualTo(
                    LottoRank.SECOND);
        });
    }
}