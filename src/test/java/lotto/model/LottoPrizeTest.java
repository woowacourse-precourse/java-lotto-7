package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

    @DisplayName("정수를 입력받아 올바른 등수를 반환한다.")
    @Test
    void 정수를_입력받아_올바른_등수를_반환한다() {
        assertEquals(LottoPrize.FIRST, LottoPrize.from(6));
        assertEquals(LottoPrize.THIRD, LottoPrize.from(5));
        assertEquals(LottoPrize.FOURTH, LottoPrize.from(4));
        assertEquals(LottoPrize.FIFTH, LottoPrize.from(3));
        assertEquals(LottoPrize.NOTHING, LottoPrize.from(1));
    }

    @DisplayName("올바른 당첨액을 반환한다.")
    @Test
    void 올바른_당첨액을_반환한다() {
        assertEquals(0, LottoPrize.NOTHING.prize());
    }

    @DisplayName("올바른 등수 정보를 반환한다.")
    @Test
    void 올바른_등수_정보를_반환한다() {
        assertEquals("Nothing", LottoPrize.NOTHING.info());
    }
}