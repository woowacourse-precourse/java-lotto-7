package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.lotto.Lotto;
import lotto.model.LottoPrizeCalculator;
import lotto.model.lottoprize.LottoPrizes;
import lotto.model.lotto.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = retryUntilValid(this::readPurchaseAmount);

        String lottoCount = purchaseAmount.calculatePurchaseLottoCount();
        outputView.printLottoCount(lottoCount);

        Lottos lottos = generateLottos(lottoCount);
        List<String> lottoNumbers = lottos.getLottoNumbers();
        outputView.printLottoNumbers(lottoNumbers);

        String winningNumbersInput = inputView.readWinningNumbers();
        Lotto mainNumbers = retryUntilValid(() -> Lotto.of(winningNumbersInput));
        String bonusNumber = inputView.readBonusNumber();
        WinningNumbers winningNumbers = retryUntilValid(() -> new WinningNumbers(mainNumbers, bonusNumber));

        LottoPrizes lottoPrizes = new LottoPrizes(lottos, winningNumbers);

        LottoPrizeCalculator lottoPrizeCalculator = new LottoPrizeCalculator(lottoPrizes);

        List<String> matchStatistics = lottoPrizeCalculator.generateMatchStatistics();
        outputView.printMatchStatistics(matchStatistics);

        String yield = lottoPrizeCalculator.calculateYield(lottos.getTotalPrice());
        outputView.printYield(yield);
    }

    private static Lottos generateLottos(String lottoCount) {
        int lottoCountNumber = Integer.parseInt(lottoCount);
        return Lottos.fromCount(lottoCountNumber);
    }

    private PurchaseAmount readPurchaseAmount() {
        String lottoBudgetInput = inputView.readPurchaseAmount();
        return new PurchaseAmount(lottoBudgetInput);
    }

    private <T> T retryUntilValid(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
