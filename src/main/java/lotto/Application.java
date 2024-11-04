package lotto;

import java.util.List;

public class Application {
    private final LottoNumberInput inputHandler = new LottoNumberInput();
    private final LottoOutput outputHandler = new LottoOutput();
    private final LottoGame lottoGame = new LottoGame();

    public void run() {
        try {
            int amount = inputHandler.getPurchaseAmount();
            lottoGame.purchaseLottos(amount);
            outputHandler.displayPurchaseInfo(amount / 1000, lottoGame.getPurchasedLottos());

            List<Integer> winningNumbers = inputHandler.getWinningNumbers();
            int bonusNumber = inputHandler.getBonusNumber();
            lottoGame.setWinningNumbers(winningNumbers, bonusNumber);

            int[] matchCounts = lottoGame.calculateResults();
            double profitRate = lottoGame.calculateProfitRate(matchCounts, amount);
            outputHandler.displayResults(matchCounts, profitRate);

        } catch (NumberFormatException e) {
            outputHandler.displayErrorMessage("write correct number");
        } catch (IllegalArgumentException e) {
            outputHandler.displayErrorMessage(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
