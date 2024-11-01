package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerFactory;
import lotto.model.dto.LottoResultDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class DrawGames {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoController controller;

    public DrawGames() {
        inputView = new InputView();
        outputView = new OutputView();
        LottoControllerFactory controllerFactory = new LottoControllerFactory();
        controller = controllerFactory.createLottoController();
    }

    public void run() {
        final String insertedMoney = inputView.purchaseLottery();
        outputView.newLine();
        final LottoResultDto lottoResult = controller.buyLotto(insertedMoney);
        outputView.printLottoResult(lottoResult.lottoResult(), lottoResult.lotteryCount());
        outputView.newLine();
        final String winningNumbers = inputView.inputWinningNumbers();
        outputView.newLine();
        final String bonusNumber = inputView.inputBonusNumber();
        outputView.newLine();
        final WinningLottoNumbersDto winningLottoNumbersDto =
                controller.setWinningNumbers(winningNumbers, bonusNumber);
    }
}
