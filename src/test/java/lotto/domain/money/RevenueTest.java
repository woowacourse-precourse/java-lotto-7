package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RevenueTest {

    @DisplayName("로또 결과를 통해 수익률을 반환하는 테스트")
    @Test
    void revenueTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addLottoResult(LottoPrize.SECOND_PRIZE);
        lottoResult.addLottoResult(LottoPrize.THIRD_PRIZE);
        lottoResult.addLottoResult(LottoPrize.FOURTH_PRIZE);
        Revenue revenue = new Revenue(lottoResult, new LottoMoney(5000));
        assertAll(() -> assertThat(revenue.getReturns()).isEqualTo(631000.0),
                () -> assertThat(revenue.getRevenue()).isEqualTo(31550000)
        );
    }
}
