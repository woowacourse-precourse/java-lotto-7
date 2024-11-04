package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.LottoPrizes;
import lotto.model.Lottos;
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

        String WinningNumbersInput = inputView.readWinningNumbers();
        Lotto mainNumbers = retryUntilValid(() -> Lotto.of(WinningNumbersInput));
        String bonusNumber = inputView.readBonusNumber();
        WinningNumbers winningNumbers = retryUntilValid(() -> new WinningNumbers(mainNumbers, bonusNumber));

        LottoPrizes lottoPrizes = new LottoPrizes(lottos, winningNumbers);

        List<String> matchStatistics = lottoPrizes.calculateMatchStatistics();
        outputView.printMatchStatistics(matchStatistics);

        String yield = lottoPrizes.calculateYield(purchaseAmount.getValue());
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
