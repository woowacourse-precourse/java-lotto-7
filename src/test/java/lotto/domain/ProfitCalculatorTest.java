package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.dto.BonusNumber;
import lotto.dto.PurchaseAmount;
import lotto.dto.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {
    private ProfitCalculator profitCalculator;
    private WinningResult winningResult;
    private PurchaseAmount purchaseAmount;

    @BeforeEach
    void setUp() {
        profitCalculator = new ProfitCalculator();

        // 로또 구입을 위한 금액 설정
        purchaseAmount = new PurchaseAmount("1000"); // 1,000원

        // 1등 당첨으로 가정하여 WinningResult를 초기화
        Lottos lottos = createWinningLottos();
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        WinningNumbersCombinations winningCombinations = new WinningNumbersCombinations(winningNumbers, bonusNumber);

        winningResult = new WinningResult(lottos, winningCombinations);
    }

    private Lottos createWinningLottos() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        return new Lottos(Arrays.asList(winningLotto));
    }

    @Test
    void calculateProfit() {
        double profit = profitCalculator.calculateProfit(winningResult, purchaseAmount);
        assertThat(profit).isEqualTo(200000000);
    }
}