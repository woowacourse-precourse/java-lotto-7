package lotto;

import lotto.utility.MatchedCountNameEnum;
import lotto.utility.ProfitCalculator;
import lotto.utility.RandomNumberCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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
        assertThat(ProfitCalculator.calculate(8000, matchedCount)).isEqualTo(BigDecimal.valueOf(62.5));
    }

    @Test
    void 하나의_1등이_당첨됐을_경우() {
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo(BigDecimal.valueOf(40000000));
    }

    @Test
    void 하나의_2등이_당첨됐을_경우() {
        matchedCount.put(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo(BigDecimal.valueOf(600000));
    }

    @Test
    void 하나의_3등이_당첨됐을_경우() {
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo(BigDecimal.valueOf(30000));
    }

    @Test
    void 하나의_4등이_당첨됐을_경우() {
        matchedCount.put(MatchedCountNameEnum.FOUR_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo(BigDecimal.valueOf(1000));
    }

    @Test
    void 여러_개의_경우_1() {
        matchedCount.put(MatchedCountNameEnum.THREE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo(BigDecimal.valueOf(40030100));
    }

    @Test
    void 여러_개의_경우_2() {
        matchedCount.put(MatchedCountNameEnum.FOUR_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo(BigDecimal.valueOf(40631000));
    }

    @Test
    void 여러_개의_경우_3() {
        matchedCount.put(MatchedCountNameEnum.THREE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FOUR_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage(), 1);
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), 1);
        assertThat(ProfitCalculator.calculate(5000, matchedCount)).isEqualTo(BigDecimal.valueOf(40631100));
    }
}
