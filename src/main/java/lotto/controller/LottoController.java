package lotto.controller;

import lotto.domain.lotto.PurchasedLottos;
import lotto.domain.lotto.WinningLottos;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.WinningNumbers;
import lotto.domain.result.WinningResult;
import lotto.global.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        WinningResult winningResult = generateWinningResult();
        displayResults(winningResult);
    }

    private WinningResult generateWinningResult() {
        PurchasedLottos purchasedLottos = purchaseLottos();
        WinningNumbers winningNumbers = inputWinningNumbers();
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);

        return createWinningResult(purchasedLottos, winningNumbers, bonusNumber);
    }

    private PurchasedLottos purchaseLottos() {
        PurchasedLottos purchasedLottos = inputPurchaseLottos();
        outputView.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private PurchasedLottos inputPurchaseLottos() {
        return retryOnException(() ->
                PurchasedLottos.from(inputView.readPurchaseAmount())
        );
    }

    private WinningNumbers inputWinningNumbers() {
        return retryOnException(() ->
                WinningNumbers.from(inputView.readWinningNumbers())
        );
    }

    private BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        return retryOnException(() ->
                BonusNumber.from(inputView.readBonusNumber(), winningNumbers)
        );
    }

    private WinningResult createWinningResult(
            PurchasedLottos purchasedLottos,
            WinningNumbers winningNumbers,
            BonusNumber bonusNumber
    ) {
        return retryOnException(() -> {
            WinningLottos winningLottos = WinningLottos.of(purchasedLottos, winningNumbers, bonusNumber);
            return WinningResult.of(winningLottos, purchasedLottos.getPurchasedLottos().size());
        });
    }

    private void displayResults(WinningResult winningResult) {
        outputView.printWinningStatistics(winningResult);
    }

    private <T> T retryOnException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return retryOnException(supplier);
        }
    }
}