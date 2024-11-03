package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.common.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("LottoResult 모델 테스트")
class LottoResultTest {
    private LottoResult lottoResult;

    @DisplayName("초기화된 상태에서 모든 등수의 당첨 카운트는 0이다.")
    @Test
    void initializeWinningCountIsZero() {
        // given
        LottoResult lottoResult = LottoResult.initialize();

        // when & then
        for (LottoRank rank : LottoRank.values()) {
            assertEquals(0, lottoResult.getWinningCount(rank));
        }
    }

    @DisplayName("1등이 당첨되면 1등의 당첨 카운트가 증가한다.")
    @Test
    void increaseFirstRankCountWhenFirstRankIsWin() {
        // given
        LottoResult lottoResult = LottoResult.initialize();

        // when
        lottoResult = lottoResult.addResult(LottoRank.FIRST);

        // then
        assertEquals(1, lottoResult.getWinningCount(LottoRank.FIRST));
    }
}