package lotto.controller;

import lotto.view.UserInput;

public class ApplicationController {
    private final UserInputController userInputController = new UserInputController();
    private final LottoServiceController lottoServiceController;
    public ApplicationController(){
        userInputController.purchaseAmountInput();
        lottoServiceController = new LottoServiceController();
        lottoServiceController.displayUserLottos();
        userInputController.winningLottoInput();
        lottoServiceController.displayWinRecord();
        lottoServiceController.displayTotalYield();
    }
}
