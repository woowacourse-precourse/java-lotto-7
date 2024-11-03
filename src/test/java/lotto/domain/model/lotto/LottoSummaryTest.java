package lotto.domain.model.lotto;

import lotto.domain.model.lotto.result.LottoSummary;
import lotto.domain.model.user.LottoRank;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class LottoSummaryTest {

    @Nested
    @DisplayName("getProfitRate 메서드는")
    class GetProfitRateTest {

        @Test
        @DisplayName("유저가 당첨된 로또의 상금을 기반으로 수익률을 계산한다.")
        void evaluateUserLotto() {
            //given
            int amount = 5000;
            LottoRank first = LottoRank.FIRST;
            LottoRank second = LottoRank.SECOND;
            LottoRank third = LottoRank.THIRD;
            LottoRank fourth = LottoRank.FOURTH;
            LottoRank fifth = LottoRank.FIFTH;
            HashMap<LottoRank, Long> resultMap = new HashMap<>();
            resultMap.put(first, 1L);
            resultMap.put(second, 1L);
            resultMap.put(third, 1L);
            resultMap.put(fourth, 1L);
            resultMap.put(fifth, 1L);
            LottoSummary testSummary = LottoSummary.create(resultMap);

            //when
            double profitRate = testSummary.getProfitRate(amount);

            //then
            Assertions.assertThat(profitRate)
                    .isCloseTo(40631000.0, Percentage.withPercentage(0.01)); // 0.01% 범위
        }
    }
}