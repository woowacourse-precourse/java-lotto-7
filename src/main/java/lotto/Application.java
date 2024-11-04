package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            LottoGenerator lottoGenerator = new LottoGenerator();

            int purchaseAmount = inputView.readPurchaseAmount();
            int quantity = new LottoQuantityCalculator().calculateLottoQuantity(purchaseAmount);

            List<Lotto> lottos = lottoGenerator.generateLottos(quantity);
            outputView.printPurchaseAmount(quantity);
            outputView.printLottoNumbers(lottos);

            List<Integer> winningNumbers = inputView.readWinningNumbers();
            int bonusNumber = inputView.readBonusNumber();

            LottoStatistics stats = new LottoStatistics();
            for (Lotto lotto : lottos) {
                LottoResult result = new LottoResult(lotto, winningNumbers, bonusNumber);
                stats.addRank(result.getRank());
            }

            outputView.printStatistics(stats);
            outputView.printProfitRate(stats.calculateProfitRate(purchaseAmount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
