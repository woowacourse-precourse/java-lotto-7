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

    @Test
    @DisplayName("4개 번호 일치 시 FOURTH 등수 반환")
    void shouldReturnFourthPrizeWhenFourNumbersMatch() {
        assertEquals(Prize.FOURTH, Prize.valueOf(4, false));
    }

    @Test
    @DisplayName("3개 번호 일치 시 FIFTH 등수 반환")
    void shouldReturnFifthPrizeWhenThreeNumbersMatch() {
        assertEquals(Prize.FIFTH, Prize.valueOf(3, false));
    }

    @Test
    @DisplayName("2개 이하 번호 일치 시 NONE 등수 반환")
    void shouldReturnNonePrizeWhenTwoOrLessNumbersMatch() {
        assertEquals(Prize.NONE, Prize.valueOf(2, false));
        assertEquals(Prize.NONE, Prize.valueOf(1, false));
        assertEquals(Prize.NONE, Prize.valueOf(0, false));
    }
}
