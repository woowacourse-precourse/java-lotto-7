package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ProfitCalculatorTest {

    @DisplayName("수익률을 계산한다.")
    @Test
    void 수익률을_계산한다() {
        assertSimpleTest(() -> {
            Map<Rank, Integer> results = new EnumMap<>(Rank.class);
            results.put(Rank.FIRST, 0);
            results.put(Rank.SECOND, 0);
            results.put(Rank.THIRD, 0);
            results.put(Rank.FOURTH, 0);
            results.put(Rank.FIFTH, 1);

            double profitRate = ProfitCalculator.calculateProfitRate(results, 8000);
            assertThat(profitRate).isEqualTo(62.5);
        });
    }
}
