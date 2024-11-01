package lotto.controller;

import lotto.service.LottoPurchaseService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoGameController {
    private final LottoPurchaseService lottoPurchaseServiceImpl;
    private final InputView consoleInputView;
    private final OutputView consoleOutputView;

    public LottoGameController(OutputView consoleOutputView
            , InputView consoleInputView
            , LottoPurchaseService lottoPurchaseServiceImpl) {

        this.lottoPurchaseServiceImpl = lottoPurchaseServiceImpl;
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;

    }

    public void run (){
        while (true) {
            try{
                String rawPurchaseAmount =  consoleInputView.inputPurchaseAmount();
                lottoPurchaseServiceImpl.purchaseLottos(rawPurchaseAmount);

                break;

            } catch (IllegalArgumentException e){
                consoleOutputView.outputErrorMessage(e.getMessage());
            }
        }


    }
}
