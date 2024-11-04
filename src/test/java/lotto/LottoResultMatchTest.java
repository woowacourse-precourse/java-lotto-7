package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultMatchTest {

    @Test
    @DisplayName("조건에 보너스 매칭 필요 없다면 실제로 보너스 매칭되어도 매칭이 되어야 함.")
    void matchBonusFalse() {
        LottoResult result = LottoResult.FIRST;

        Assertions.assertTrue(result.isMatch(6, true));
        Assertions.assertTrue(result.isMatch(6, false));
    }

    @Test
    @DisplayName("조건에 보너스 매칭이 필요하면 반드시 보너스 매칭일 true여야 함")
    void matchBonusTrue() {
        LottoResult result = LottoResult.SECOND;

        Assertions.assertFalse(result.isMatch(5, false));
        Assertions.assertTrue(result.isMatch(5, true));
    }

}