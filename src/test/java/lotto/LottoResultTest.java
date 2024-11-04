package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("matchCount별 옳은 LottoResult 반환하는지 확인")
    @Test
    void matchCount별_옳은_LottoResult_반환하는지_확인() {
        assertEquals(LottoResult.FIRST, LottoResult.fromMatchCount(6, false)); // 6
        assertEquals(LottoResult.SECOND, LottoResult.fromMatchCount(5, true)); // 5+1
        assertEquals(LottoResult.THIRD, LottoResult.fromMatchCount(5, false)); // 5
    }
}