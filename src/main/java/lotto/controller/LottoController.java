package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void lotto(){
        readUserBudget();
    }



    public int readUserBudget(){
        OutputView.printBudgetInputDescription();
        return InputView.inputBudget();
    }
}
