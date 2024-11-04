package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    @DisplayName("LottoResult 객체가 올바르게 생성되는지 테스트")
    void createLottoResult() {
        int winningResult = 5;
        boolean bonusResult = true;

        LottoResult lottoResult = new LottoResult(winningResult, bonusResult);

        assertEquals(winningResult, lottoResult.getWinningResult());
        assertTrue(lottoResult.isBonusResult());
    }

    @Test
    @DisplayName("LottoResult 객체가 false로 생성되는지 테스트")
    void createLottoResult_WithFalseBonus() {
        int winningResult = 4;
        boolean bonusResult = false;

        LottoResult lottoResult = new LottoResult(winningResult, bonusResult);

        assertEquals(winningResult, lottoResult.getWinningResult());
        assertFalse(lottoResult.isBonusResult());
    }
}
