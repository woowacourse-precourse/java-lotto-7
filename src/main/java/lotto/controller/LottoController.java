package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String purchaseAmountInput = getPurchaseAmount();

        LottoTicket lottoTicket = generateAndPrintLottoTicket(purchaseAmountInput);
        WinningLotto winningLotto = getAndCreateWinningLotto();
        LottoResult lottoResult = createAndPrintLottoResult(lottoTicket, winningLotto, purchaseAmountInput);

        printReturnOnInvestment(lottoResult.getReturnOnInvestment());
    }

    private String getPurchaseAmount() {
        return inputView.getPurchaseAmountInput();
    }

    private LottoTicket generateAndPrintLottoTicket(String purchaseAmountInput) {
        LottoTicket lottoTicket = lottoService.generateLottoTicket(purchaseAmountInput);
        outputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private WinningLotto getAndCreateWinningLotto() {
        String winningNumbers = inputView.getWinningNumbersInput();
        String bonusNumber = inputView.getBonusNumberInput();
        return lottoService.createWinningLotto(winningNumbers, bonusNumber);
    }

    private LottoResult createAndPrintLottoResult(LottoTicket lottoTicket, WinningLotto winningLotto, String purchaseAmountInput) {
        LottoResult lottoResult = lottoService.createLottoResult(lottoTicket, winningLotto, purchaseAmountInput);
        outputView.printWinningStatistics(lottoResult);
        return lottoResult;
    }

    private void printReturnOnInvestment(double returnOnInvestment) {
        outputView.printReturnOnInvestment(returnOnInvestment);
    }
}
