package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    void 당첨_수익을_계산한다() {
        LottoResult lottoResult = new LottoResult(
                List.of(Prize.FIFTH_PRIZE, Prize.SECOND_PRIZE, Prize.NO_PRIZE, Prize.NO_PRIZE));
        long totalProfit = lottoResult.calculateTotalProfit();
        long expectedProfit = Prize.FIFTH_PRIZE.getMoney() + Prize.SECOND_PRIZE.getMoney();
        assertThat(totalProfit).isEqualTo(expectedProfit);
    }

}