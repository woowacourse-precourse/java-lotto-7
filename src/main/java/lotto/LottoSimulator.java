package lotto;

import java.util.List;

public class LottoSimulator {
    private final LottoShop lottoShop;

    public LottoSimulator(LottoShop lottoShop) {
        this.lottoShop = lottoShop;
    }

    public void start() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        LottoTickets lottoTickets = purchaseTickets(purchaseAmount);
        WinningLotto winningLotto = getWinningLotto();
        LottoWinningResult lottoWinningResult = getWinningResult(lottoTickets, winningLotto);
        getTotalProfitResult(purchaseAmount, lottoWinningResult);
    }

    private PurchaseAmount getPurchaseAmount() {
        OutputHandler.printInputPurchaseAmountMessage();
        return new PurchaseAmount(InputHandler.requestPurchaseAmount());
    }

    private LottoTickets purchaseTickets(PurchaseAmount purchaseAmount) {
        LottoTickets lottoTickets = lottoShop.publishTickets(purchaseAmount);
        OutputHandler.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private static WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private static List<Integer> getWinningNumbers() {
        OutputHandler.printInputWinningNumbers();
        List<Integer> winningNumbers = InputHandler.requestWinningNumber();
        return winningNumbers;
    }

    private static int getBonusNumber() {
        OutputHandler.printInputBonusNumbers();
        int bonusNumber = InputHandler.requestBonusNumber();
        return bonusNumber;
    }

    private static LottoWinningResult getWinningResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        LottoWinningResult lottoWinningResult = getLottoWinningResult(lottoTickets, winningLotto);
        OutputHandler.printWinningStatistics(lottoWinningResult);
        return lottoWinningResult;
    }

    private static LottoWinningResult getLottoWinningResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return LottoWinningCalculator.calculateWinningResults(lottoTickets, winningLotto);
    }

    private static void getTotalProfitResult(PurchaseAmount purchaseAmount, LottoWinningResult lottoWinningResult) {
        double totalProfitRate = purchaseAmount.calculateTotalProfitRate(lottoWinningResult);
        OutputHandler.printTotalProfitRate(totalProfitRate);
    }
}
