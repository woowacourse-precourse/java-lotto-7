package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.score.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {
    @Test
    void 오등상_수익_계산() {
        //given
        LottoJudge judge = new LottoJudge();
        List<Lotto> lottos = new ArrayList<>();
        YieldCalculator calculator = new YieldCalculator();
        LottoWinningSet lottoWinningSet = new LottoWinningSet(Arrays.asList(4, 5, 6, 7, 8, 9), 10);
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //when
        Map<Prize, Integer> prizeScore = judge.calculateLottoScore(lottos, lottoWinningSet);
        int prizeMoney = calculator.calculatePrizeMoney(prizeScore);

        //then
        Assertions.assertThat(prizeMoney).isEqualTo(5000);
    }

    @Test
    void 수익률_계산() {
        //given
        int investmentMoney = 5000;
        int prizeMoney = 8000;
        YieldCalculator yieldCalculator = new YieldCalculator();

        //when
        String rateOfReturn = yieldCalculator.calculateRateOfReturn(8000, 5000);

        //then
        Assertions.assertThat(rateOfReturn).isEqualTo("62.5%");
    }
}