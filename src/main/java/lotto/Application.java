package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            try {
                InputView inputView = new InputView();
                int purchaseAmount = inputView.readPurchaseAmount();

                LottoGenerator generator = new LottoGenerator();
                List<Lotto> lottos = generator.generateLottos(purchaseAmount);

                OutputView.printLottoCount(lottos.size());
                OutputView.printLottos(lottos);

                WinningNumbers winningNumbers = inputView.readWinningNumbers();
                ResultCalculator calculator = new ResultCalculator(winningNumbers, lottos);
                Statistics statistics = calculator.calculate();

                OutputView.printStatistics(statistics);
                break;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
