package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoVendingMachine;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.PurchaseAmount;
import lotto.dto.request.PurchaseAmountDTO;
import lotto.dto.request.WinningLottoBonusNumberDTO;
import lotto.dto.request.WinningLottoNumbersDTO;
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
        PurchaseAmount purchaseAmount = generateValidatedPurchaseAmount();
        PurchasedLottos purchasedLottos = lottoVendingMachine.purchase(purchaseAmount);
        displayPurchasedLottos(purchasedLottos);

        WinningLotto winningLotto = generateValidatedWinningLotto();

        LottoResult lottoResult = LottoResult.of(
                purchasedLottos.calculateRankCounts(winningLotto)
        );
        displayResults(lottoResult, purchaseAmount);
    }

    private PurchaseAmount generateValidatedPurchaseAmount() {
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

    private WinningLotto generateValidatedWinningLotto() {
        return Repeater.executeWithRetry(
                () -> {
                    Lotto winningLotto = generateWinningLottoFromInput();
                    LottoNumber bonusNumber = generateBonusNumberFromInput();
                    return WinningLotto.of(
                            winningLotto,
                            bonusNumber
                    );
                },
                outputView::printError
        );
    }

    private Lotto generateWinningLottoFromInput() {
        WinningLottoNumbersDTO winningLottoNumbersDTO = inputView.inputWinningLottoNumbers();
        return Lotto.from(winningLottoNumbersDTO.numbers());
    }

    private LottoNumber generateBonusNumberFromInput() {
        WinningLottoBonusNumberDTO winningLottoBonusNumberDTO = inputView.inputWinningLottoBonusNumber();
        return LottoNumber.of(winningLottoBonusNumberDTO.bonusNumber());
    }
}
