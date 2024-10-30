package lotto.controller;

import lotto.lotto.Lotto;
import lotto.handler.InputHandler;
import lotto.handler.PrintHandler;
import lotto.lotto.LottoStore;

public class Controller {
    InputHandler inputHandler;
    PrintHandler printHandler;
    Lotto lotto;
    LottoStore lottoStore;

    public Controller() {
        inputHandler = new InputHandler();
        printHandler = new PrintHandler();
        lottoStore = new LottoStore();
    }

    public void run () {
        printHandler.PrintBuyMoneyAmount();
        inputHandler.setInputMoney();
        int money = inputHandler.getInputMoney();
        lottoStore.calculateNumberOfPurchases(money);

    }
}
