package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.message.SystemMessage;

public class LottoMachine {
    private final InputView inputView = new InputView();
    private final Validator validator = new Validator();
    private final OutputView outputView = new OutputView();

    public List<Lotto> getLotteries() {
        return
        String input = "";
        do {
            input = inputView.input(SystemMessage.INPUT_PURCHASE_MONEY_AMOUNT.getMessage());
        } while (!validateMoneyAmount(input));
    }

    public boolean validateMoneyAmount(String moneyAmount) {
        return
    }

    public Lotto generateLotto() {
        return
    }

}
