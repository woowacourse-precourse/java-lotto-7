package lotto.service;

import lotto.domain.Amount;
import lotto.view.InputView;

public class UserService {
    private final InputView inputView;

    public UserService(){
        this.inputView = new InputView();
    }

    public int inputAmount(){
        Amount amount = new Amount(inputView.inputAmountView());
        return amount.getAmount();
    }
}
