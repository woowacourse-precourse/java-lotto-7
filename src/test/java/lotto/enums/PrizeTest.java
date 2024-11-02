package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeTest {

    @Test
    @DisplayName("6개 번호 일치 시 FIRST 등수 반환")
    void shouldReturnFirstPrizeWhenSixNumbersMatch() {
        assertEquals(Prize.FIRST, Prize.valueOf(6, false));
        assertEquals(Prize.FIRST, Prize.valueOf(6, true));
    }
}
