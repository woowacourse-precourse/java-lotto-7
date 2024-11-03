package lotto.test;

import lotto.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lotto 게임의 결과를 계산하는 LottoResult에서")
public class LottoResultTest {
    @Test
    @DisplayName("lotto의 번호들과 보너스 번호, 당첨 번호와의 일치 수에 따라 등수의 횟수를 증가시킨다")
    public void calculateResult() {
        //given
        LottoResult gameResult = new LottoResult();
        //when
        gameResult.calculateResult(4, 1);
        //then
        Assertions.assertThat(gameResult.printTotalWinningCount())
                .contains("5개 일치 (1,500,000원) - 1개");
    }

    @Test
    @DisplayName("lotto 결과에 따른 수익률을 반환한다")
    public void calculateEarningRate() {
        //given
        LottoResult gameResult = new LottoResult();
        //when
        gameResult.calculateResult(4, 1);
        //then
        Assertions.assertThat(gameResult.calculateEarningRate(1000))
                .contains("150000.0%");
    }
}
