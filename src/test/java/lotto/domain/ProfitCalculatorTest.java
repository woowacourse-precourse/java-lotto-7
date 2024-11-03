package lotto.domain;

import lotto.dto.MatchResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfitCalculatorTest {
    ProfitCalculator profitCalculator;

    @BeforeEach
    void init() {
        profitCalculator = new ProfitCalculator();
    }

    @DisplayName("당첨 번호와의 비교 결과에 따라 총 당첨 금액을 계산한다.")
    @Test
    void calculateTotalWinningAmount() {

        List<MatchResult> matchResults = List.of(
                new MatchResult(6, false),
                new MatchResult(5, true),
                new MatchResult(5, false)
        );

        long totalWinningAmount = profitCalculator.calculateTotalWinningAmount(matchResults);

        Assertions.assertThat(totalWinningAmount).isEqualTo(2_031_500_000);
    }
}
