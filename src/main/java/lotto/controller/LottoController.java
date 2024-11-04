package lotto.controller;

import lotto.io.LottoInputHandler;
import lotto.io.LottoOutputHandler;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.service.LottoService;
import lotto.util.LottoNumberParser;
import lotto.util.LottoValidator;

import java.util.List;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class LottoController {
    private final LottoInputHandler inputHandler;
    private final LottoOutputHandler outputHandler;
    private final LottoService lottoService;

    public LottoController(LottoInputHandler inputHandler, LottoOutputHandler outputHandler, LottoService lottoService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int lottoTicketCount = calculateLottoTicketCount(purchaseAmount);
        showLottoTicketCount(lottoTicketCount);

        List<Lotto> lottoTickets = lottoService.generateLottoTickets(lottoTicketCount);
        outputHandler.showPurchasedLottos(lottoTickets);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto.getNumbers());

        LottoResult result = lottoService.evaluateResults(lottoTickets, winningLotto, bonusNumber);
    }

    private int getPurchaseAmount() {
        outputHandler.showPurchaseAmountPrompt();
        return handlePurchaseAmountInput();
    }

    private int handlePurchaseAmountInput() {
        while (true) {
            try {
                String purchaseAmount = inputHandler.getPurchaseAmount();
                int validPurchaseAmount = LottoValidator.parseNumber(purchaseAmount);
                LottoValidator.validatePurchaseAmount(validPurchaseAmount);
                System.out.println();
                return validPurchaseAmount;
            } catch (IllegalArgumentException e) {
                outputHandler.showErrorMessage(e.getMessage());
                outputHandler.showPurchaseAmountPrompt();
            }
        }
    }

    private int calculateLottoTicketCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void showLottoTicketCount(int count) {
        outputHandler.showPurchasedLottoCount(count);
    }

    private Lotto getWinningLotto() {
        outputHandler.showWinningNumbersPrompt();
        return handleWinningLottoInput();
    }

    private Lotto handleWinningLottoInput() {
        while (true) {
            try {
                List<Integer> winningNumbers = LottoNumberParser.parseWinningNumbers(inputHandler.getWinningNumbers());
                LottoValidator.validateWinningNumbers(winningNumbers);
                System.out.println();
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputHandler.showErrorMessage(e.getMessage());
                outputHandler.showWinningNumbersPrompt();
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        outputHandler.showBonusNumberPrompt();
        return handleBonusNumberInput(winningNumbers);
    }

    private int handleBonusNumberInput(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumber = inputHandler.getBonusNumber();
                int validBonusNumber = LottoValidator.parseNumber(bonusNumber);
                LottoValidator.validateBonusNumber(validBonusNumber, winningNumbers);
                System.out.println();
                return validBonusNumber;
            } catch (IllegalArgumentException e) {
                outputHandler.showErrorMessage(e.getMessage());
                outputHandler.showBonusNumberPrompt();
            }
        }
    }
}
