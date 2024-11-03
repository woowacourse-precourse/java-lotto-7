package lotto.handler;

import java.util.Map;
import lotto.LottoPrize;
import lotto.view.OutputView;

public class LottoResultController {

    private final OutputView outputView;

    public LottoResultController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void handle(Integer inputPrice, Map<LottoPrize, Integer> prizeIntegerMap) {
        long result = prizeIntegerMap.entrySet().stream()
            .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();

        double investment = (double) result / inputPrice;

        outputView.printInvestment(investment);
    }
}
