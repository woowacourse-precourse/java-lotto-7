package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
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
}
