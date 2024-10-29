package controller;

import model.Amount;
import model.LottoAmount;
import validation.Validation;
import view.InputView;

public class LottoController {
    private final InputView inputView;
    private Amount purchaseAmount;
    private LottoAmount lottoAmount;
    public LottoController(InputView inputView){
        this.inputView = inputView;
    }
    public void run(){
        String str = inputView.purchaseAmount();
        Validation.blankInput(str);
        Validation.numberInput(str);
        Validation.overInput(Integer.parseInt(str));
        purchaseAmount = new Amount(Integer.parseInt(str));
        lottoAmount = new LottoAmount(purchaseAmount.getPurchaseAmount());
    }
}
