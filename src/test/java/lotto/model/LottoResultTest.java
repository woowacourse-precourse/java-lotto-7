package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @DisplayName("각 당첨 결과를 올바르게 기록하는지 테스트")
    @Test
    void 각_당첨_결과를_올바르게_기록하는지_테스트() {
        // 1등 1개, 3등 2개, 5등 1개 기록
        lottoResult.record(WinningRank.FIRST);
        lottoResult.record(WinningRank.THIRD);
        lottoResult.record(WinningRank.THIRD);
        lottoResult.record(WinningRank.FIFTH);

        Map<WinningRank, Integer> results = lottoResult.getResults();

        assertThat(results.getOrDefault(WinningRank.FIRST, 0)).isEqualTo(1);
        assertThat(results.getOrDefault(WinningRank.SECOND, 0)).isEqualTo(0);
        assertThat(results.getOrDefault(WinningRank.THIRD, 0)).isEqualTo(2);
        assertThat(results.getOrDefault(WinningRank.FOURTH, 0)).isEqualTo(0);
        assertThat(results.getOrDefault(WinningRank.FIFTH, 0)).isEqualTo(1);
    }

    @DisplayName("총 상금을 정확하게 계산하는지 테스트")
    @Test
    void 총_상금을_정확하게_계산하는지_테스트() {
        lottoResult.record(WinningRank.FIRST);
        lottoResult.record(WinningRank.THIRD);
        lottoResult.record(WinningRank.THIRD);
        lottoResult.record(WinningRank.FIFTH);

        // 총 상금 계산: 2,000,000,000 + 1,500,000 * 2 + 5,000 = 2,003,005,000
        assertThat(lottoResult.totalPrize()).isEqualTo(2003005000);
    }

    @DisplayName("아무 당첨 결과가 없을 때 상금은 0이어야 한다.")
    @Test
    void 아무_당첨_결과가_없을_때_상금은_0이어야_한다() {
        int totalPrize = lottoResult.totalPrize();

        assertThat(totalPrize).isEqualTo(0);
    }
}