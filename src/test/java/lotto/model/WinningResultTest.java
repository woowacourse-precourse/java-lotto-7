package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {

    @Test
    void 당첨_내역을_토대로_수익률을_계산한다(){
        WinningResult winningResult = new WinningResult();
        Amount amount;

        amount = new Amount(8000);
        winningResult.put(Reward.FIFTH);

        Assertions.assertThat(winningResult.getProfitRate(amount)).isEqualTo(62.5);
    }

}