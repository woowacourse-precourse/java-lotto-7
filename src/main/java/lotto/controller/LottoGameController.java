package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;
import lotto.io.input.GameInput;
import lotto.io.output.GameOutput;
import lotto.service.LottoService;

public class LottoGameController {
    private final GameInput gameInput;
    private final GameOutput gameOutput;
    private final LottoService lottoService;

    public LottoGameController(GameInput gameInput, GameOutput gameOutput, LottoService lottoService) {
        this.gameInput = gameInput;
        this.gameOutput = gameOutput;
        this.lottoService = lottoService;
    }

    public void start() {
        try {
            PurchaseAmount purchaseAmount = getPurchaseAmount();
            LottoTicket lottoTicket = lottoService.generateLottoTickets(purchaseAmount.getTicketCount());
            gameOutput.printPurchasedTickets(lottoTicket);

            WinningNumbers winningNumbers = getWinningNumbers();
            BonusNumber bonusNumber = getBonusNumber(winningNumbers);

            Result result = lottoService.calculateResult(lottoTicket, winningNumbers, bonusNumber);
            displayYield(purchaseAmount, result);
        } finally {
            gameOutput.close();
        }
    }

    private PurchaseAmount getPurchaseAmount() {
        while (true) {
            try {
                return lottoService.createPurchaseAmount(gameInput.getPurchaseAmountInput());
            } catch (IllegalArgumentException e) {
                gameOutput.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                return lottoService.createWinningNumbers(gameInput.getWinningNumbersInput());
            } catch (IllegalArgumentException e) {
                gameOutput.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                return lottoService.createBonusNumber(gameInput.getBonusNumberInput(), winningNumbers);
            } catch (IllegalArgumentException e) {
                gameOutput.printErrorMessage(e.getMessage());
            }
        }
    }

    private void displayYield(PurchaseAmount purchaseAmount, Result result) {
        String yield = lottoService.calculateYield(purchaseAmount, result);
        gameOutput.printResults(result, yield);
    }
}
