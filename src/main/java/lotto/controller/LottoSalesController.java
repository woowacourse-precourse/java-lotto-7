package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.InputAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSalesController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoSalesController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        InputAmount inputAmount = prepareInputAmount();

        Console.close();
    }

    private InputAmount prepareInputAmount() {
        outputView.printInputAmount();
        return new InputAmount(inputView.getAmount());
    }

}
