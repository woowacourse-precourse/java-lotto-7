package lotto.controller;

import java.util.List;
import lotto.dto.LottoPurchaseDetails;
import lotto.dto.WinningStatistics;
import lotto.model.Lotto;
import lotto.model.LottoGroup;
import lotto.model.LottoPurchaseAmount;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;
import lotto.rank.Ranking;
import lotto.util.NumLottoCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachineController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            LottoPurchaseAmount lottoPurchaseAmount = requestPurchaseAmount();
            LottoGroup purchasedLottos = purchaseLotto(lottoPurchaseAmount);
            WinningLotto winningLotto = requestWinningLotto();
            WinningResult winningResult = calculateWinningResult(purchasedLottos, winningLotto);

            displayWinningStatistics(lottoPurchaseAmount, winningResult);
        } catch (IllegalStateException e) {
            outputView.printExitMessage(e.getMessage());
        }
    }

    private LottoGroup purchaseLotto(LottoPurchaseAmount lottoPurchaseAmount) {
        long purchaseAmount = lottoPurchaseAmount.purchaseAmount();
        long numLotto = calcNumLotto(purchaseAmount);

        LottoGroup purchasedLottos = new LottoGroup(numLotto);
        displayPurchaseDetails(purchasedLottos);

        return purchasedLottos;
    }

    private LottoPurchaseAmount requestPurchaseAmount() {
        outputView.printPurchaseAmountRequestMessage();
        return new LottoPurchaseAmount(inputView.readPurchaseAmount());
    }

    private static long calcNumLotto(long purchaseAmount) {
        return NumLottoCalculator.calculate(purchaseAmount);
    }

    private void displayPurchaseDetails(LottoGroup lottoGroup) {
        outputView.printPurchaseDetailsMessage(new LottoPurchaseDetails(lottoGroup));
    }

    private WinningLotto requestWinningLotto() {
        outputView.printWinningNumbersRequestMessage();
        List<Integer> winningNumbers = inputView.readWinningNumbers();

        outputView.printBonusNumberRequestMessage();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private WinningResult calculateWinningResult(LottoGroup purchasedLottos, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        for (Lotto lotto : purchasedLottos.getLottos()) {
            int matchCount = getMatchCount(winningLotto, lotto);
            boolean bonusMatch = getBonusMatch(winningLotto, lotto);

            Ranking ranking = Ranking.valueOf(matchCount, bonusMatch);
            winningResult.addRankCount(ranking);
        }

        return winningResult;
    }

    private static int getMatchCount(WinningLotto winningLotto, Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getWinningNumbers()::contains)
                .count();
    }

    private static boolean getBonusMatch(WinningLotto winningLotto, Lotto lotto) {
        return lotto.getNumbers()
                .contains(winningLotto.getBonusNumber());
    }

    private void displayWinningStatistics(LottoPurchaseAmount lottoPurchaseAmount, WinningResult winningResult) {
        outputView.printWinningStatisticsMessage(new WinningStatistics(lottoPurchaseAmount, winningResult));
    }
}
