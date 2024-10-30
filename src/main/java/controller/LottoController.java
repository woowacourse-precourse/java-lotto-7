package controller;

import model.Amount;
import model.LottoAmount;
import validation.Validation;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private Amount purchaseAmount;
    private LottoAmount lottoAmount;
    public LottoController(InputView inputView,OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void run(){
        String str = inputView.purchaseAmount();
        Validation.blankInput(str);
        Validation.numberInput(str);
        Validation.overInput(Integer.parseInt(str));
        purchaseAmount = new Amount(Integer.parseInt(str));
        lottoAmount = new LottoAmount(purchaseAmount.getPurchaseAmount());
        outputView.printLottoAmount(lottoAmount);
    }
}
