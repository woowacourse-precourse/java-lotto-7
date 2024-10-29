package controller;

import model.Amount;
import validation.Validation;
import view.InputView;

public class LottoController {
    private final InputView inputView;
    public LottoController(InputView inputView){
        this.inputView = inputView;
    }
    public void run(){
        String str = inputView.purchaseAmount();
        Validation.blankInput(str);
        Validation.numberInput(str);
        Validation.overInput(Integer.parseInt(str));
        Amount purchaseAmount = new Amount(Integer.parseInt(str));
    }
}
