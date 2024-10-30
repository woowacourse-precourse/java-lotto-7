package controller;

import camp.nextstep.edu.missionutils.Randoms;
import view.InputHandler;
import view.OutputHandler;

import java.util.List;

public class LottoController {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    public LottoController() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void run(){
        outputHandler.promptForAmountInput();
        int amountInput = inputHandler.getAmountInput();
        int count = amountInput / 1000;
        outputHandler.displayPurchasedLottoCount(count);
        for(int i = 0; i < count; i++){
            System.out.println(Randoms.pickUniqueNumbersInRange(1,45,6).toString());
        }



        outputHandler.promptForLottoNumber();
        List<Integer> lottoNumber = inputHandler.getLottoNumber();
        outputHandler.promptForBonusNumber();
        int bonusNumber = inputHandler.getBonusNumber();

    }
}
