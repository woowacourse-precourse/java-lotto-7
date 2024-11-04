package lotto;

import lotto.model.LottoRank;
import lotto.model.LottosResult;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    void 총_수익률을_잘_계산하는지_테스트() {
        assertSimpleTest(() -> {
            // given
            LottosResult lottosResult = new LottosResult();
            lottosResult.plus(LottoRank.FOURTH);
            lottosResult.plus(LottoRank.FIFTH);
            lottosResult.plus(LottoRank.OUT_OF_RANK);
            lottosResult.plus(LottoRank.OUT_OF_RANK);
            double totalRevenue = 55000;
            int totalQuantity = 4;
            double predictRateOfReturn = totalRevenue / totalQuantity / 10;
            predictRateOfReturn = Math.round(predictRateOfReturn * 10) / 10.0;

            // when
            double actualRateOfReturn = lottosResult.getRateOfReturn();
            actualRateOfReturn = Math.round(actualRateOfReturn * 10) / 10.0;

            // then
            assertThat(actualRateOfReturn).isEqualTo(predictRateOfReturn);
        });
    }
}
