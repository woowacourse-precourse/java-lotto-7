package lotto.controller;

import lotto.model.vo.WinningNumber;

public class LottoGameController {
    private final LottoController lottoController;
    private final LottoStatisticController lottoStatisticController;
    private final WinningNumbersController winningNumbersController;


    public LottoGameController(LottoController lottoController, LottoStatisticController lottoStatisticController,
                               WinningNumbersController winningNumbersController) {
        this.lottoController = lottoController;
        this.lottoStatisticController = lottoStatisticController;
        this.winningNumbersController = winningNumbersController;
    }

    public void run() {
        lottoController.buy();

        WinningNumber winningNumber = winningNumbersController.createWinningNumber();

        lottoStatisticController.calculate(winningNumber);
    }
}
