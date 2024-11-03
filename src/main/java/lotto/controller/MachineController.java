package lotto.controller;

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

        OutputView.printBlankLine();
        
        OutputView.printInputBonusNumberMessage();
        int bonusNumber = InputView.readBonusNumber();

        return new Computer(winningNumbers);
    }

    private void printLottoQuantityAndNumbers(int quantity, List<Lotto> lotto) {
        OutputView.printLottoQuantity(quantity);

        for (Lotto oneOfLotto : lotto) {
            OutputView.printLottoNumbers(oneOfLotto.getNumbers());
        }
    }
}
