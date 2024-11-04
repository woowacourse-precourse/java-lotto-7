package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.controller.generator.NumberGenerator;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Statistics;
import lotto.model.Store;
import lotto.model.WinningLotto;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Store store;

    public LottoController(final InputView inputView, final OutputView outputView,
                           final NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.store = new Store(numberGenerator);
    }

    public void start() {
        final Money purchaseMoney = getPurchaseMoney();
        final List<Lotto> purchasedLottos = purchaseLottos(purchaseMoney);
        displayPurchasedLottos(purchasedLottos);

        final WinningLotto winningLotto = generateWinningLotto();
        displayResults(purchasedLottos, winningLotto);
    }

    private Money getPurchaseMoney() {
        return executeWithRetry(() -> Money.fromString(inputView.readPurchaseAmount()));
    }

    private List<Lotto> purchaseLottos(final Money purchaseAmount) {
        return store.purchaseLottos(purchaseAmount);
    }

    private void displayPurchasedLottos(final List<Lotto> purchasedLottos) {
        outputView.printPurchaseResults(purchasedLottos);
    }

    private WinningLotto generateWinningLotto() {
        final Lotto winningLottoNumbers = getWinningLottoNumbers();
        final BonusNumber bonusNumber = getBonusNumber(winningLottoNumbers);
        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    private Lotto getWinningLottoNumbers() {
        return executeWithRetry(() -> Lotto.fromStringList(inputView.readWinningNumber()));
    }

    private BonusNumber getBonusNumber(final Lotto winningNumbers) {
        return executeWithRetry(() -> BonusNumber.of(inputView.readBonusNumber(), winningNumbers));
    }

    private void displayResults(final List<Lotto> purchasedLottos, final WinningLotto winningLotto) {
        final Statistics statistics = store.calculateLottoResult(winningLotto, purchasedLottos);
        outputView.printStatisticsResults(statistics);
    }

    private <T> T executeWithRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
