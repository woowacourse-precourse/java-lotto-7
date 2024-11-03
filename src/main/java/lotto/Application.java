package lotto;

import java.util.List;

public class Application {

    private static final int LOTTO_PRICE_UNIT = 1000;

    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        WinningNumberInput winningNumberInput = new WinningNumberInput();
        LottoResult lottoResult = new LottoResult();

        int purchaseAmount = getPurchaseAmount(lottoPurchase);
        List<Lotto> purchasedLottos = generateAndPrintTickets(lottoPurchase, purchaseAmount);
        getWinningNumbers(winningNumberInput);
        printResultsAndYield(lottoResult, purchasedLottos, winningNumberInput, purchaseAmount);
    }

    private static int getPurchaseAmount(LottoPurchase lottoPurchase) {
        return lottoPurchase.getPurchaseAmount();
    }

    private static List<Lotto> generateAndPrintTickets(LottoPurchase lottoPurchase, int purchaseAmount) {
        int ticketCount = purchaseAmount / LOTTO_PRICE_UNIT;
        List<Lotto> purchasedLottos = lottoPurchase.generateLottoTickets(ticketCount);
        System.out.println(ticketCount + "개를 구매했습니다.");
        lottoPurchase.printLottoTickets(purchasedLottos);
        return purchasedLottos;
    }

    private static void getWinningNumbers(WinningNumberInput winningNumberInput) {
        winningNumberInput.inputWinningNumbers();
        winningNumberInput.inputBonusNumber();
    }

    private static void printResultsAndYield(LottoResult lottoResult, List<Lotto> purchasedLottos,
                                             WinningNumberInput winningNumberInput, int purchaseAmount) {
        lottoResult.calculateResult(purchasedLottos, winningNumberInput.getWinningNumbers(),
                winningNumberInput.getBonusNumber());
        lottoResult.printResults();
        double yield = lottoResult.calculateYield(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
