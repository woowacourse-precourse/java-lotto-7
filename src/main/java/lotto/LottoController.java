package lotto;

import java.util.List;

public class LottoController {

    public void start() {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount);

        List<Lotto> tickets = lottoPurchase.getTickets();
        OutputView.displayPurchasedTickets(tickets);

        List<String> winningNumbers = InputView.getWinningNumber();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);

        List<Integer> winningNumberList = winningNumbers.stream()
                                                        .map(Integer::parseInt)
                                                        .toList();

        int[] results = Result.calculateResults(tickets, winningNumberList, bonusNumber);
        double profitRate = Result.calculateProfitRate(results, purchaseAmount);

        OutputView.displayResults(results, profitRate);
    }
}
