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
        while (true) {
            try {
                String money = inputView.readMoney();
                lottoSimulator = new LottoSimulator(money);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        lottoSimulator.buyRandomLotto();
        outputView.printLottoGroup(lottoSimulator.getPurchasedLotto());
    }

    private void drawNumbers() {
        while (true) {
            try {
                String winningNumbers = inputView.readWinningNumbers();
                Draw draw = new Draw(winningNumbers);

                String bonusNumber = inputView.readBonusNumber();
                draw.putBonusNumber(bonusNumber);
                lottoSimulator.countPrize(draw);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void calculatePrize(){
        outputView.printStatics(lottoSimulator.getPrizeResult());
        double profitRate = lottoSimulator.checkProfitRate();
        outputView.printProfitRate(profitRate);
    }
}
