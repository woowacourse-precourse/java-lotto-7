package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;
import lotto.io.input.GameInput;
import lotto.io.output.GameOutput;

public class LottoGameController {
    private final GameInput gameInput;
    private final GameOutput gameOutput;

    public LottoGameController(GameInput gameInput, GameOutput gameOutput) {
        this.gameInput = gameInput;
        this.gameOutput = gameOutput;
    }

    public void start() {
        try {
            PurchaseAmount purchaseAmount = createPurchaseAmount();
            LottoTicket lottoTicket = LottoTicket.from(purchaseAmount.getTicketCount());
            gameOutput.printPurchasedTickets(lottoTicket);

            WinningNumbers winningNumbers = createWinningNumbers();
            BonusNumber bonusNumber = createBonusNumber(winningNumbers);

            Result result = Result.from(lottoTicket, winningNumbers, bonusNumber);
            displayYield(purchaseAmount, result);
        } finally {
            gameOutput.close();
        }
    }

    private PurchaseAmount createPurchaseAmount() {
        while (true) {
            try {
                return new PurchaseAmount(gameInput.getPurchaseAmountInput());
            } catch (IllegalArgumentException e) {
                gameOutput.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers createWinningNumbers() {
        while (true) {
            try {
                return new WinningNumbers(gameInput.getWinningNumbersInput());
            } catch (IllegalArgumentException e) {
                gameOutput.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber createBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                return new BonusNumber(gameInput.getBonusNumberInput(), winningNumbers.getWinningNumbers());
            } catch (IllegalArgumentException e) {
                gameOutput.printErrorMessage(e.getMessage());
            }
        }
    }

    private void displayYield(PurchaseAmount purchaseAmount, Result result) {
        String yield = purchaseAmount.calculateYield(result.getTotalPrize());
        gameOutput.printResults(result, yield);
    }
}
