package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("로또 결과를 나타낸다.")
    @Test
    void 로또_결과를_나타낸다() {
        Result result = Result.valueOf(5, 0);
        assertEquals(result.matchCount, 5);
        assertEquals(result.winningAmount, 1_500_000);
        assertEquals(result.message, "5개 일치");
    }
}