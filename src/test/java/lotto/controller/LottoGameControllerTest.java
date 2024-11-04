package lotto.controller;

import lotto.service.LottoGeneratorService;
import lotto.service.LottoPurchaseService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.TestInputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameControllerTest {
    LottoGameController controller;

    @BeforeEach
    void setUp() {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(new TestInputView("10000"));
        OutputView outputView = new OutputView();
        LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();
        InputView inputView = new TestInputView("10000");
        WinningNumberService winningNumberService = new WinningNumberService();
        controller = new LottoGameController(lottoPurchaseService, outputView, lottoGeneratorService, inputView, winningNumberService);
    }
    @Test
    void purchaseLotto() {
        controller.purchaseLotto();
    }
}