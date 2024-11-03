package lotto.controller;

import lotto.view.OutputView;

public class LottoController {

    public void lotto(){
        readUserBudget();
    }
    public void readUserBudget(){
        OutputView.printBudgetInputDescription();
    }
}
