package lotto.controller;

import lotto.view.UserInput;

public class ApplicationController {
    private final UserInputController userInputController = new UserInputController();
    private LottoServiceController lottoServiceController;
    public ApplicationController(){
        try{
            userInputController.purchaseAmountInput();
            lottoServiceController = new LottoServiceController();
            lottoServiceController.displayUserLottos();
            userInputController.winningLottoInput();
            lottoServiceController.displayWinRecord();
            lottoServiceController.displayTotalYield();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
