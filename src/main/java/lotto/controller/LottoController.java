package lotto.controller;

import lotto.domain.Money;
import lotto.view.ErrorView;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;
    private final ErrorView errorView;

    public LottoController(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public void startLottoDraw() {
        Money money = getMoney();
    }

    private Money getMoney() {
        Money money = null;

        while (money == null) {
            try {
                String moneyInput = inputView.requestMoneyInput();
                int parsedMoney = Integer.parseInt(moneyInput);
                money = new Money(parsedMoney);
            } catch (NumberFormatException e) {
                errorView.printMoneyParsingError();
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }

        return money;
    }
}
