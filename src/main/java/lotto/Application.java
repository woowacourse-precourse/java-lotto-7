package lotto;

import lotto.handlers.InputHandler;
import lotto.handlers.LottoHandler;
import lotto.handlers.ResultHandler;
import lotto.models.LottoResults;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoHandler lottoHandler = new LottoHandler(new OutputView());
        InputHandler inputHandler = new InputHandler(new InputView());
        ResultHandler resultHandler = new ResultHandler(new OutputView(), new LottoResults());

        inputHandler.handlePurchaseAmountInput(lottoHandler, resultHandler);
        inputHandler.handleWinningTicketInput(resultHandler);

        resultHandler.printResults(lottoHandler);
    }
}
