package lotto.controller;

import lotto.lotto.Lotto;
import lotto.handler.InputHandler;
import lotto.handler.PrintHandler;

public class Controller {
    InputHandler inputHandler;
    PrintHandler printHandler;
    Lotto lotto;

    public Controller() {
        inputHandler = new InputHandler();
        printHandler = new PrintHandler();
    }

    public void run () {
        printHandler.PrintBuyMoneyAmount();
        inputHandler.setInputMoney();

    }
}
