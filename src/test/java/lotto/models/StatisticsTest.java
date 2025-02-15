package lotto.models;

import lotto.utils.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsTest {

    private Statistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new Statistics();
    }

    @Test
    void 모든_상금_카운트가_초기화시_제로인지_확인한다() {
        for (Prize prize : Prize.values()) {
            assertEquals(0, statistics.getCount(prize), prize + " count should be initialized to 0.");
        }
    }

    @Test
    void 상금_카운트를_증가시키면_정상적으로_증가하는지_확인한다() {
        statistics.increment(Prize.THREE);
        statistics.increment(Prize.THREE);
        assertEquals(2, statistics.getCount(Prize.THREE), "Prize THREE count should be incremented by 2.");

        statistics.increment(Prize.FIVE_AND_BONUS);
        assertEquals(1, statistics.getCount(Prize.FIVE_AND_BONUS), "Prize FIVE_AND_BONUS count should be incremented by 1.");
    }

    @Test
    void 통계에서_모든_상금별_카운트가_정확한지_확인한다() {
        statistics.increment(Prize.THREE);
        statistics.increment(Prize.FOUR);
        statistics.increment(Prize.FOUR);
        statistics.increment(Prize.SIX);

        Map<Prize, Integer> result = statistics.get();

        assertEquals(1, result.get(Prize.THREE), "Prize THREE count should be 1.");
        assertEquals(2, result.get(Prize.FOUR), "Prize FOUR count should be 2.");
        assertEquals(0, result.get(Prize.FIVE), "Prize FIVE count should be 0.");
        assertEquals(0, result.get(Prize.FIVE_AND_BONUS), "Prize FIVE_AND_BONUS count should be 0.");
        assertEquals(1, result.get(Prize.SIX), "Prize SIX count should be 1.");
    }
}
