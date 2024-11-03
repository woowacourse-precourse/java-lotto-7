package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MachineController {
    public void start() {
        OutputView.printInputPurchaseAmountMessage();
        int purchaseAmount = InputView.readPurchaseAmount();

        OutputView.printBlankLine();

        User user = new User(purchaseAmount);
        printLottoQuantityAndNumbers(user.getQuantity(), user.getLotto());
    }

    private void printLottoQuantityAndNumbers(int quantity, List<Lotto> lotto) {
        OutputView.printLottoQuantity(quantity);
        
        for (Lotto oneOfLotto : lotto) {
            OutputView.printLottoNumbers(oneOfLotto.getNumbers());
        }
    }
}
