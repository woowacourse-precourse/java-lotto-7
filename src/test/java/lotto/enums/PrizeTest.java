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

    @Test
    @DisplayName("5개 번호 + 보너스 번호 일치 시 SECOND 등수 반환")
    void shouldReturnSecondPrizeWhenFiveNumbersAndBonusMatch() {
        assertEquals(Prize.SECOND, Prize.valueOf(5, true));
    }

    @Test
    @DisplayName("5개 번호 일치 + 보너스 번호 불일치 시 THIRD 등수 반환")
    void shouldReturnThirdPrizeWhenFiveNumbersMatchWithoutBonus() {
        assertEquals(Prize.THIRD, Prize.valueOf(5, false));
    }
}
