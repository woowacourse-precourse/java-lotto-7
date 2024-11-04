package lotto;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final ResultCalculator resultCalculator = new ResultCalculator();
    private final OutputView outputView = new OutputView();

    public void start() {
        int purchaseAmount = inputView.readPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        outputView.printLottos(lottos);

        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);

        Map<Rank, Integer> result = resultCalculator.calculateResults(lottos, winningNumbers, bonusNumber);

        int totalPrize = calculateTotalPrize(result);
        double profitRate = resultCalculator.calculateProfitRate(totalPrize, purchaseAmount);

        outputView.printResults(result, purchaseAmount, totalPrize, profitRate);
    }

    private int calculateTotalPrize(Map<Rank, Integer> result) {
        return result.entrySet().stream()
                .mapToInt(e -> e.getKey().getPrize() * e.getValue())
                .sum();
    }
}