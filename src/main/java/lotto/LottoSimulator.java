package lotto;

import java.util.List;
import java.util.function.Supplier;

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
        return requestValidInput(
                () -> new PurchaseAmount(InputHandler.requestPurchaseAmount()),
                OutputHandler::printInputPurchaseAmountMessage
        );
    }

    private LottoTickets purchaseTickets(PurchaseAmount purchaseAmount) {
        LottoTickets lottoTickets = lottoShop.publishTickets(purchaseAmount);
        OutputHandler.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = requestValidInput(InputHandler::requestWinningNumber, OutputHandler::printInputWinningNumbers);
        int bonusNumber = requestValidInput(InputHandler::requestBonusNumber, OutputHandler::printInputBonusNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private <T> T requestValidInput(Supplier<T> inputMethod, Runnable outputMethod) {
        while (true) {
            try {
                outputMethod.run();
                return inputMethod.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
