package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.LottoVendingMachine;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.domain.vo.PurchaseAmount;
import lotto.dto.request.PurchaseAmountDTO;
import lotto.dto.response.PurchasedLottosDTO;
import lotto.util.Repeater;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final LottoVendingMachine lottoVendingMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(
            LottoVendingMachine lottoVendingMachine,
            InputView inputView,
            OutputView outputView
    ) {
        this.lottoVendingMachine = lottoVendingMachine;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = getValidatedPurchaseAmount();
        PurchasedLottos purchasedLottos = lottoVendingMachine.purchase(purchaseAmount);
        displayPurchasedLottos(purchasedLottos);

        WinningLotto winningLotto = registerValidatedWinningLotto();

        LottoResult lottoResult = LottoResult.of(
                purchasedLottos.calculateRankCounts(winningLotto)
        );
        displayResults(lottoResult, purchaseAmount);
    }

    private PurchaseAmount getValidatedPurchaseAmount() {
        return Repeater.executeWithRetry(
                () -> {
                    PurchaseAmountDTO purchaseAmountDTO = inputView.inputPurchaseAmount();
                    return PurchaseAmount.of(purchaseAmountDTO.purchaseAmount());
                },
                outputView::printError
        );
    }

    private void displayPurchasedLottos(PurchasedLottos purchasedLottos) {
        PurchasedLottosDTO responseDTO = PurchasedLottosDTO.from(purchasedLottos);
        outputView.printPurchasedLottos(responseDTO);
    }
}
