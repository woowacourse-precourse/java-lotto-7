package lotto.controller;

import java.util.function.Supplier;
import lotto.model.LottoPrizeCalculator;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lottoprize.LottoPrizes;
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
        outputView.printLottoCount(purchaseAmount.calculatePurchaseLottoCount());

        Lottos lottos = createLottos(purchaseAmount);
        outputView.printLottoNumbers(lottos.getLottoNumbers());

        WinningNumbers winningNumbers = readWinningNumbers();
        LottoPrizes lottoPrizes = new LottoPrizes(lottos, winningNumbers);
        LottoPrizeCalculator lottoPrizeCalculator = new LottoPrizeCalculator(lottoPrizes);

        outputView.printMatchStatistics(lottoPrizeCalculator.generateMatchStatistics());
        outputView.printYield(lottoPrizeCalculator.calculateYield(lottos.getTotalPrice()));
    }

    private Lottos createLottos(PurchaseAmount purchaseAmount) {
        int lottoCountNumber = Integer.parseInt(purchaseAmount.calculatePurchaseLottoCount());
        return Lottos.fromCount(lottoCountNumber);
    }

    private WinningNumbers readWinningNumbers() {
        String winningNumbersInput = inputView.readWinningNumbers();
        Lotto mainNumbers = retryUntilValid(() -> Lotto.of(winningNumbersInput));
        String bonusNumber = inputView.readBonusNumber();
        return retryUntilValid(() -> new WinningNumbers(mainNumbers, bonusNumber));
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
