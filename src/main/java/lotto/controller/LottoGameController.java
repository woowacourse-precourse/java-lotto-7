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
        int paidMoney = getPaidMoney();
        LotteryMachine machine = new LotteryMachine(paidMoney);
        outputView.printLottos(machine.getLottos());

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        LottoChecker checker = new LottoChecker(winningNumbers, bonusNumber);
        WinningRank.winningCounts(machine.getLottos(), checker);
        outputView.printWinningsResult();

        Calculator calculator = new Calculator(paidMoney);
        outputView.printEarningRate(calculator.calculateEarningRate());
    }

    private int getPaidMoney() {
        while (true) {
            try {
                return inputView.purchaseLotto();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                return inputView.inputWinningNumber();
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 숫자는 6개만 입력해 주세요.");
            }
        }
    }

}
