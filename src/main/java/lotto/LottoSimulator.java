package lotto;

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
        Lotto winningNumbers = getWinningNumbers();
        WinningLotto winningLotto = requestValidInput(() -> // 보너스 번호 입력받기
                        new WinningLotto(winningNumbers, InputHandler.requestBonusNumber()),
                OutputHandler::printInputBonusNumbers
        );
        return winningLotto;
    }

    private Lotto getWinningNumbers() {
        Lotto winningNumbers = requestValidInput(
                () -> new Lotto(InputHandler.requestWinningNumber()),
                OutputHandler::printInputWinningNumbers
        );
        return winningNumbers;
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
