package lotto;

import lotto.utility.MatchedCountNameEnum;
import lotto.utility.ProfitCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitCalculatorTest {
    private static Map<String, Integer> matchedCount;

    @BeforeEach
    void 맞힌개수_초기화() {
        matchedCount = new HashMap<>();
        matchedCount.put(MatchedCountNameEnum.THREE_MATCHED.getMessage(), 0);
        matchedCount.put(MatchedCountNameEnum.FOUR_MATCHED.getMessage(), 0);
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 0);
        matchedCount.put(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage(), 0);
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 0);
    }

    @Test
    void 지원페이지_예제_케이스() {
        matchedCount.put(MatchedCountNameEnum.THREE_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(8000, matchedCount)).isEqualTo("62.5");
    }

    @Test
    void 하나의_1등이_당첨됐을_경우() {
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo("40,000,000.0");
    }

    @Test
    void 하나의_2등이_당첨됐을_경우() {
        matchedCount.put(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo("600,000.0");
    }

    @Test
    void 하나의_3등이_당첨됐을_경우() {
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo("30,000.0");
    }

    @Test
    void 하나의_4등이_당첨됐을_경우() {
        matchedCount.put(MatchedCountNameEnum.FOUR_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo("1,000.0");
    }

    @Test
    void 하나의_5등이_당첨됐을_경우() {
        matchedCount.put(MatchedCountNameEnum.THREE_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo("100.0");
    }

    @Test
    void 여러_개의_경우_1() {
        matchedCount.put(MatchedCountNameEnum.THREE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo("40,030,100.0");
    }

    @Test
    void 여러_개의_경우_2() {
        matchedCount.put(MatchedCountNameEnum.FOUR_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo("40,631,000.0");
    }

    @Test
    void 여러_개의_경우_3() {
        matchedCount.put(MatchedCountNameEnum.THREE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FOUR_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo("40,631,100.0");
    }

    @Test
    void 여러_개의_경우_4() {
        matchedCount.put(MatchedCountNameEnum.THREE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FOUR_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(1000, matchedCount)).isEqualTo("203,155,500.0");
    }

    @Test
    void 여러_개의_경우_5() {
        matchedCount.put(MatchedCountNameEnum.THREE_MATCHED.getMessage(), 47998);
        matchedCount.put(MatchedCountNameEnum.FOUR_MATCHED.getMessage(), 2891);
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 59);
        matchedCount.put(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage(), 2);
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(2147483000, matchedCount)).isEqualTo("118.0");
    }

    @Test
    void 여러_개의_경우_6() {
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(2000000000, matchedCount)).isEqualTo("100.0");
    }

    @Test
    void 수익이_없을_경우() {
        assertThat(ProfitCalculator.calculate(2147483000, matchedCount)).isEqualTo("0.0");
    }
}
