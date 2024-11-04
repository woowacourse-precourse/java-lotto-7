package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;
import lotto.domain.LottoBuyer;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryServiceTest {
    private OutputView outputView;
    private InputView inputView;
    private LottoBuyer lottoBuyer;
    private LottoBonus lottoBonus;
    private LotteryService lotteryService;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        inputView = new InputView();
        lottoBuyer = new LottoBuyer();
        lottoBonus = new LottoBonus();
        lotteryService = new LotteryService();
    }

    @DisplayName("로또 수익률 계산 테스트")
    @Test
    void 로또_수익률_계산_테스트() {
        int purchaseAmount = 10000;
        int totalWinningAmount = 5000;
        double expectedYield = 50.0;
        double actualYield = lottoBuyer.calculateLotteryYield(purchaseAmount, totalWinningAmount);
        assertEquals(expectedYield, actualYield);
    }
}
