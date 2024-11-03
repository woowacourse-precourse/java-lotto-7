package lotto.controller;

import java.util.List;
import lotto.model.Calculator;
import lotto.model.LotteryMachine;
import lotto.model.LottoChecker;
import lotto.model.WinningRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int paidMoney = inputView.purchaseLotto();

        LotteryMachine machine = new LotteryMachine(paidMoney);
        machine.drawLottos();
        outputView.printLottos(machine.getLottos());

        List<Integer> winningNumbers = inputView.inputWinningNumber();
        int bonusNumber = inputView.inputBonusNumber();

        LottoChecker checker = new LottoChecker(winningNumbers, bonusNumber);
        WinningRank.winningCounts(machine.getLottos(), checker);
        outputView.printWinningsResult();

        Calculator calculator = new Calculator(paidMoney);
        outputView.printEarningRate(calculator.calculateEarningRate());
    }

}
