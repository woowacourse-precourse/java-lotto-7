package lotto.controller;

import lotto.io.LottoInputHandler;
import lotto.io.LottoOutputHandler;
import lotto.model.Lotto;
import lotto.service.LottoService;
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
}
