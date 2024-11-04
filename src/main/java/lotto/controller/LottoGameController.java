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
    private static final String WRONG_INPUT_MONEY = "[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.";
    private static final String WRONG_INPUT_STRING = "[ERROR] 숫자를 입력해 주세요.";


    public LottoGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int paidMoney = getPaidMoney();
        LotteryMachine machine = new LotteryMachine(paidMoney);
        machine.drawLottos();
        outputView.printLottos(machine.getLottos());

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        LottoChecker checker = new LottoChecker(winningNumbers, bonusNumber);
        WinningRank.winningCounts(machine.getLottos(), checker);
        outputView.printWinningsResult();

        Calculator calculator = new Calculator(paidMoney);
        outputView.printEarningRate(calculator.calculateEarningRate());
    }

    private int getPaidMoney() {
        while (true) {
            try {
                int paidMoney = inputView.purchaseLotto();
                return paidMoney;
            } catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT_STRING);
            } catch (IllegalArgumentException e) {
                System.out.println(WRONG_INPUT_MONEY);
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                return inputView.inputWinningNumber();
            } catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT_STRING);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                return inputView.inputBonusNumber();
            } catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT_STRING);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
