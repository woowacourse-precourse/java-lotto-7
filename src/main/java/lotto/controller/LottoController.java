package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static final String DELIMITER_COMMA = ",";

    public void lotto(){
        readUserBudget();
    }

    public int readUserBudget(){
        OutputView.printBudgetInputDescription();
        return InputView.inputBudget();
    }

    public List<Integer> readWinningNumber(){
        OutputView.printWinningNumberInputDescription();
        return InputView.inputWinningNumber();
    }

}
