package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.message.SystemMessage;

public class LottoMachine {
    private final InputView inputView = new InputView();
    private final Validator validator = new Validator();
    private final OutputView outputView = new OutputView();

    public List<Lotto> getLotteries() {
        String input = "";
        do {
            input = inputView.input(SystemMessage.INPUT_PURCHASE_MONEY_AMOUNT.getMessage());
        } while (!validateMoneyAmount(input));
    }

    public boolean validateMoneyAmount(String moneyAmount) {
        try {
            validator.isNotNull(moneyAmount);
            validator.isNumber(moneyAmount);
            int number = Integer.parseInt(moneyAmount);
            validator.isOverMinimumPurchaseAmount(number);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return false;
        }
        return true;
    }
}
