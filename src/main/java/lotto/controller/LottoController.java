package lotto.controller;

import lotto.domain.Lotto;
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
        String purchaseAmountInput = getPurchaseAmountInput();
        LottoTicket lottoTicket = generateAndPrintLottoTicket(purchaseAmountInput);

        Lotto winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        WinningLotto winningLotto = createWinningLotto(winningNumbers, bonusNumber);

        LottoResult lottoResult = createAndPrintLottoResult(lottoTicket, winningLotto, purchaseAmountInput);
        printReturnOnInvestment(lottoResult.getReturnOnInvestment());
    }

    private String getPurchaseAmountInput() {
        while (true) {
            try {
                return inputView.getPurchaseAmountInput();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoTicket generateAndPrintLottoTicket(String purchaseAmountInput) {
        while (true) {
            try {
                LottoTicket lottoTicket = lottoService.generateLottoTicket(purchaseAmountInput);
                outputView.printLottoTicket(lottoTicket);
                return lottoTicket;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                purchaseAmountInput = getPurchaseAmountInput();
            }
        }
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = inputView.getWinningNumbersInput();
                return lottoService.parseAndValidateWinningNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = inputView.getBonusNumberInput();
                return lottoService.parseAndValidateBonusNumber(bonusNumberInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningLotto createWinningLotto(Lotto winningNumbers, int bonusNumber) {
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
