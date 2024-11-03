package lotto.controller;

import lotto.model.Draw;
import lotto.model.LottoSimulator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoSimulator lottoSimulator;

    public LottoSimulatorController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        issueLotto();
        drawNumbers();
        calculatePrize();
    }

    private void issueLotto() {
        String money = inputView.readMoney();
        lottoSimulator = new LottoSimulator(money);
        lottoSimulator.buyRandomLotto();
        outputView.printLottoGroup(lottoSimulator.getPurchasedLotto());
    }

    private void drawNumbers() {
        String winningNumbers = inputView.readWinningNumbers();
        String bonusNumber = inputView.readBonusNumber();
        Draw draw = new Draw(winningNumbers, bonusNumber);
        lottoSimulator.countPrize(draw);
    }

    private void calculatePrize(){
        outputView.printStatics(lottoSimulator.getPrizeResult());
        double profitRate = lottoSimulator.checkProfitRate();
        outputView.printProfitRate(profitRate);
    }
}
