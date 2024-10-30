package controller;

import factory.LottoFactory;
import model.Amount;
import model.LottoAmount;
import model.LottoCollection;
import validation.Validation;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoCollection lottoCollection;
    private Amount purchaseAmount;
    private LottoAmount lottoAmount;

    public LottoController(InputView inputView, OutputView outputView, LottoCollection lottoCollection) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoCollection = lottoCollection;
    }

    public void run() {
        String str = inputView.purchaseAmount();
        Validation.blankInput(str);
        Validation.numberInput(str);
        Validation.overInput(Integer.parseInt(str));
        purchaseAmount = new Amount(Integer.parseInt(str));
        lottoAmount = new LottoAmount(purchaseAmount.getPurchaseAmount());
        outputView.printLottoAmount(lottoAmount);

        makeLotto();
    }

    private void makeLotto(){
        for(int i=0;i< lottoAmount.getCount();i++){
            lottoCollection.add(LottoFactory.make());
        }
    }
}
