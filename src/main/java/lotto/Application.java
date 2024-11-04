package lotto;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = promptForPurchaseAmount();
        int lottoCount = purchaseAmount.getLottoCount();
        Lottos lottos = LottoMachine.createLottos(lottoCount);

        Output.printLottos(lottos);

        WinningLotto winningLotto = promptForWinningLotto();

        Map<Rank, Integer> statistics = lottos.calculateStatistics(winningLotto);
        double profitRate = lottos.calculateProfitRate(statistics, purchaseAmount.getAmount());
    }

    private static PurchaseAmount promptForPurchaseAmount() {
        try {
            int amount = Input.readPurchaseAmount();
            return new PurchaseAmount(amount);
        } catch (IllegalArgumentException e) {
            return promptForPurchaseAmount();
        }
    }

    private static WinningLotto promptForWinningLotto() {
        try {
            Lotto winningNumbers = Input.readWinningNumbers();
            int bonusNumber = Input.readBonusNumber();
            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            return promptForWinningLotto();
        }
    }
}
