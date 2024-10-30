package lotto.controller;

import lotto.domain.Wallet;
import lotto.view.Input;
import lotto.view.Output;

/**
 * 구매 내역 출력
 *
 */
public class MainController {
    public void run(){
        Wallet wallet = createWallet();
    }

    private Wallet createWallet() {
        while (true){
            try{
                return new Wallet(Input.inputPurchaseAmount());
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }

}
