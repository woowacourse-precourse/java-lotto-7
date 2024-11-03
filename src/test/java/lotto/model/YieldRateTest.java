package lotto.model;

import static lotto.config.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import lotto.config.LottoRank;
import lotto.vo.BuyLottoAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YieldRateTest {

    @DisplayName("로또 당첨 통계와 구매 금액을 통해서 수익률을 계산합나다")
    @Test
    void 수익률_계산() {
        Map<LottoRank, Integer> result = Map.of(
                FIRST_RANK, 0,
                SECOND_RANK, 0,
                THIRD_RANK, 2,
                FOURTH_RANK, 3,
                FIFTH_RANK, 4
        );

        BuyLottoAmount buyLottoAmount = new BuyLottoAmount(10000);

        YieldRate yieldRate = YieldRate.createYieldRate(result, buyLottoAmount);

        double expectedRate = (double) (
                        THIRD_RANK.getPrizeMoney() * 2 +
                        FOURTH_RANK.getPrizeMoney() * 3 +
                        FIFTH_RANK.getPrizeMoney() * 4) / buyLottoAmount.amount() * 100;

        assertThat(yieldRate.getRate()).isEqualTo(expectedRate);
    }
}