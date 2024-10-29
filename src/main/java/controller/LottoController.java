package controller;

import java.math.BigInteger;
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
        Amount purchaseAmount = new Amount(new BigInteger(str));
    }
}
