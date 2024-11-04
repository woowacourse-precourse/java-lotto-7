package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @ParameterizedTest
    @EnumSource(LottoRank.class)
    void 당첨된_등수_횟수를_증가시킨다(LottoRank rank) {
        // given
        int initialCount = lottoResult.getRankCounts()
                                      .get(rank);

        // when
        lottoResult.addRankCount(rank);

        // then
        assertThat(lottoResult.getRankCounts()
                              .get(rank)).isEqualTo(initialCount + 1);
    }

    @Test
    void 로또_3등_두_번_당첨되어서_총_상금은_삼백만_원이다() {
        // given
        lottoResult.addRankCount(LottoRank.THIRD);
        lottoResult.addRankCount(LottoRank.THIRD);

        BigDecimal expectedTotalPrize = new BigDecimal("3000000");

        // when
        BigDecimal totalPrize = lottoResult.calculateTotalPrize();

        // then
        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }
}
