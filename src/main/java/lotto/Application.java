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

        Output.printResult(statistics, profitRate);
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
        Lotto winningNumbers = promptForWinningNumbers();
        int bonusNumber = promptForBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private static Lotto promptForWinningNumbers() {
        while (true) {
            try {
                return Input.readWinningNumbers();
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private static int promptForBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                int bonusNumber = Input.readBonusNumber();
                new WinningLotto(winningNumbers, bonusNumber).validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }
}
