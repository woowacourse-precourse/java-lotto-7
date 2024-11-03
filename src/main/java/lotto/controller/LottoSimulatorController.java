package lotto.controller;

import lotto.model.LottoSimulator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoSimulatorController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        issueLotto();
    }

    private void issueLotto() {
        String money = inputView.readMoney();
        LottoSimulator lottoSimulator = new LottoSimulator(money);
        lottoSimulator.buyRandomLotto();
        outputView.printLottoGroup(lottoSimulator.getPurchasedLotto());
    }

    private void drawNumbers() {
        String winningNumbers = inputView.readWinningNumbers();
        String bonusNumber = inputView.readBonusNumber();
    }
}
