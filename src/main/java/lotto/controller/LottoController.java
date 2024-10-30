package lotto.controller;

import lotto.model.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private LottoManager lottoManager;

    public LottoController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void getPurchasePrice(){
        boolean check = false;
        while(!check){
            outputView.printPurchasePriceMessage();
            String price = inputView.inputPurchasePrice();
            try {
                this.lottoManager = new LottoManager(price);
                check = true;
                //System.out.println(lottoManager.toString());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}
