package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.view.OutputView;
import java.util.List;

public class OutputController {
    private final OutputView outputView;

    public OutputController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void printLottoPurchaseInfo(List<Lotto> lottos) {
        outputView.printPurchaseAmount(lottos.size());
        outputView.printLottos(lottos);
    }

    public void printGameResult(LottoResult result) {
        outputView.printResult(result);
    }

    public void printProfit(double profit) {
        outputView.printProfit(profit);
    }

    public void printError(String message) {
        outputView.printError(message);
    }
}
