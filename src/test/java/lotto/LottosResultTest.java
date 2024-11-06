package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.core.domain.model.GameResult;
import lotto.core.domain.model.Money;
import lotto.core.domain.model.PrizeOption;
import org.junit.jupiter.api.Test;

public class LottosResultTest {
    @Test
    void countProfitableTest() {

        List<PrizeOption> givenLottoResults = List.of(PrizeOption.FOUR_MATCHES, PrizeOption.SIX_MATCHES);
        int moneySpent = 200;
        GameResult lottosResult = new GameResult(givenLottoResults);

        double expectedProfit = ((PrizeOption.FOUR_MATCHES.getPrizeAmount() + PrizeOption.SIX_MATCHES.getPrizeAmount()) / (double) moneySpent) * 100;
        Money money = new Money();
        money.saveMoney(moneySpent);
        lottosResult.countProfitable(money);

        assertThat(lottosResult.getTotalProfit()).isEqualTo(expectedProfit);
    }

}
