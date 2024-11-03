package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    void 모든_등수의_초기_카운트는_0이다() {
        Arrays.stream(LottoRank.values())
                .forEach(rank -> assertThat(lottoResult.getRankCounts().get(rank)).isZero());
    }

    @Test
    void 등수_카운트가_증가해야한다() {
        // when
        lottoResult.incrementRankCount(LottoRank.FIRST);
        lottoResult.incrementRankCount(LottoRank.SECOND);

        // then
        assertThat(lottoResult.getRankCounts().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getRankCounts().get(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 당첨금이 올바르게 계산되어야 한다")
    void 총_당첨금_계산() {
        // given
        lottoResult.incrementRankCount(LottoRank.FIRST); // 2,000,000,000 원
        lottoResult.incrementRankCount(LottoRank.SECOND); // 30,000,000 원
        lottoResult.incrementRankCount(LottoRank.THIRD); // 1,500,000 원

        // when
        BigInteger totalWinnings = lottoResult.calculateTotalWinnings();

        // then
        assertThat(totalWinnings).isEqualTo(BigInteger.valueOf(2_000_000_000).add(BigInteger.valueOf(30_000_000))
                .add(BigInteger.valueOf(1_500_000)));
    }

    @Test
    @DisplayName("매우 큰 총 당첨금이 계산되어야 한다")
    void 매우_큰_당첨금_계산() {
        // given
        for (int i = 0; i < 1_000_000; i++) {
            lottoResult.incrementRankCount(LottoRank.FIRST); // 2,000,000,000 원
        }

        // when
        BigInteger totalWinnings = lottoResult.calculateTotalWinnings();

        // then
        BigInteger expectedTotalWinnings = BigInteger.valueOf(2_000_000_000).multiply(BigInteger.valueOf(1_000_000));
        assertThat(totalWinnings).isEqualTo(expectedTotalWinnings);
    }
}