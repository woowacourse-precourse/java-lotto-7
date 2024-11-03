package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.model.Computer;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MachineController {
    public void start() {
        User user = createUser();
        printLottoQuantityAndNumbers(user.getQuantity(), user.getLotto());

        OutputView.printBlankLine();

        Computer computer = createComputer();

        computer.compareLotto(user.getLotto());
        float rateOfReturn = computer.calculateRateOfReturn(user.getQuantity());

        finish(computer.getResults(), rateOfReturn);
    }

    private User createUser() {
        OutputView.printInputPurchaseAmountMessage();
        int purchaseAmount = InputView.readPurchaseAmount();

        OutputView.printBlankLine();

        return new User(purchaseAmount);
    }

    private Computer createComputer() {
        OutputView.printInputWinningNumbersMessage();
        List<Integer> winningNumbers = InputView.readWinningNumbers();
        Computer computer = new Computer(winningNumbers);

        OutputView.printBlankLine();

        OutputView.printInputBonusNumberMessage();
        int bonusNumber = InputView.readBonusNumber();
        computer.setBonusNumber(bonusNumber);

        return computer;
    }

    private void printLottoQuantityAndNumbers(int quantity, List<Lotto> lotto) {
        OutputView.printLottoQuantity(quantity);

        for (Lotto oneOfLotto : lotto) {
            OutputView.printLottoNumbers(oneOfLotto.getNumbers());
        }
    }

    private void finish(HashMap<Integer, Integer> results, float rateOfReturn) {
        OutputView.printBlankLine();

        OutputView.printWinningStatistics();
        OutputView.printResults(results);
    }
}
