package lotto.Controller;

import lotto.Domain.LottoMachine;
import lotto.Domain.PurchaseAmount;
import lotto.Utils.UserInput;

public class LottoGameController {
    private final UserInput userInput;

    public LottoGameController() {
        userInput = new UserInput();
    }

    public void run() {
        ready();
    }

    private void ready() {
        String amountInput = userInput.purchaseAmount();
        PurchaseAmount amount = PurchaseAmount.from(amountInput);
        LottoMachine machine = LottoMachine.from(amount);
        machine.buyLottos();
    }

}