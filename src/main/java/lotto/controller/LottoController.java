package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoPurchaser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private LottoPurchaser lottoPurchaser;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = getValidatedInput(inputView::readPurchaseAmount);
        purchaseLotto(purchaseAmount);

        List<Integer> winningNumbers = getValidatedInput(inputView::readWinningNumbers);
        int bonusNumber = getValidatedInput(inputView::readBonusNumber);
    }

    private <T> T getValidatedInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void purchaseLotto(int purchaseAmount) {
        lottoPurchaser = new LottoPurchaser(new LottoNumberGenerator());
        IntStream.range(0, purchaseAmount).forEach(i -> lottoPurchaser.purchaseLotto());
        outputView.printPurchasedLottos(lottoPurchaser.getPurchasedLottos());
    }
}
