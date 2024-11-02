package lotto;

import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;

public class LottoVendingMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LottoVendingMachine(){
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void vend(){

        PurchaseAmount purchaseAmount = inputHandler.inputPurChaseAmount();


    }
}
