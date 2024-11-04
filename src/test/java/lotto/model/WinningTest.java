package lotto.model;

import static lotto.model.Winning.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningTest {
    @BeforeEach
    void setUp() {
        Winning.initCount();
    }

    @Test
    void int_값으로_알맞는_Winning_가져오는지_테스트() {
        assertEquals(THREE, getFromValue(3, false));
        assertEquals(FOUR, getFromValue(4, false));
        assertEquals(FIVE, getFromValue(5, false));
        assertEquals(FIVE_BONUS, getFromValue(5, true));
        assertEquals(SIX, getFromValue(6, false));
    }

    @Test
    void count_증가_확인_테스트() {
        IntStream.range(1, 100).forEach(i ->
                assertEquals(i, THREE.increaseCount()));
    }

    @Test
    void NONE_제외하고_toString_테스트() {
        String toString = "3개 일치 (5,000원) - 0개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개\n";
        assertEquals(toString, toStringWithoutNone());

        THREE.increaseCount();

        toString = "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개\n";
        assertEquals(toString, toStringWithoutNone());
    }

    @Test
    void 당첨_count와_price를_곱한_값_테스트() {
        THREE.increaseCount();

        assertEquals(5000, getTotalWinningPrice().get().intValue());

        initCount();

        SIX.increaseCount();
        SIX.increaseCount();

        assertEquals(new BigDecimal(2000000000).multiply(BigDecimal.TWO), getTotalWinningPrice().get());
    }
}