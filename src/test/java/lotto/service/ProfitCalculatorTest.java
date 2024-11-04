package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import lotto.model.LottoRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {
    @Test
    void 수익률_계산하기() {
        ProfitCalculator profitCalculator = new ProfitCalculator();

        // 매칭 결과 맵 생성
        Map<LottoRule, Integer> matchedLotto = new HashMap<>();
        matchedLotto.put(LottoRule.SIX_MATCH, 0);
        matchedLotto.put(LottoRule.FIVE_MATCH, 0);
        matchedLotto.put(LottoRule.FIVE_MATCH_BONUS, 0);
        matchedLotto.put(LottoRule.FOUR_MATCH, 0);
        matchedLotto.put(LottoRule.THREE_MATCH, 1);

        int amount = 8000;

        double profitRate = profitCalculator.calculateProfitRate(matchedLotto, amount);

        double expectedProfitRate = 62.5;

        Assertions.assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}