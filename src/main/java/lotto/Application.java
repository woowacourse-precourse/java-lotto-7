package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        WinningNumberInput winningNumberInput = new WinningNumberInput();
        LottoResult lottoResult = new LottoResult();

        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        int ticketCount = purchaseAmount / 1000;
        List<Lotto> purchasedLottos = lottoPurchase.generateLottoTickets(ticketCount);

        System.out.println(ticketCount + "개를 구매했습니다.");
        lottoPurchase.printLottoTickets(purchasedLottos);

        winningNumberInput.inputWinningNumbers();
        winningNumberInput.inputBonusNumber();

        lottoResult.calculateResult(purchasedLottos, winningNumberInput.getWinningNumbers(),
                winningNumberInput.getBonusNumber());
        lottoResult.printResults();

        double yield = lottoResult.calculateYield(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
