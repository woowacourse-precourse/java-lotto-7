package lotto;

import lotto.controller.LottoGameController;
import lotto.model.Lotto;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoPurchaseService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(inputView);

        WinningNumberService winningNumberService = new WinningNumberService(); // Ensure this is implemented

        LottoGameController lottoGameController = new LottoGameController(
                lottoPurchaseService,
                outputView,
                lottoGeneratorService,
                inputView,
                winningNumberService
        );

        lottoGameController.run();
    }
}
