package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
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
        PurchaseAmount purchaseAmount;
        while (true) {
            try {
                purchaseAmount = new PurchaseAmount(gameInput.getPurchaseAmountInput());
                break;
            } catch (IllegalArgumentException e) {
                gameOutput.printErrorMessage(e.getMessage());
            }
        }
        LottoTicket lottoTicket = generateLottoTickets(purchaseAmount.getTicketCount());
        gameOutput.printPurchasedTickets(lottoTicket);

        WinningNumbers winningNumbers;
        while (true) {
            try {
                winningNumbers = new WinningNumbers(gameInput.getWinningNumbersInput());
                break;
            } catch (IllegalArgumentException e) {
                gameOutput.printErrorMessage(e.getMessage());
            }
        }

        BonusNumber bonusNumber;
        while (true) {
            try {
                bonusNumber = new BonusNumber(gameInput.getBonusNumberInput(), winningNumbers.getWinningNumbers());
                break;
            } catch (IllegalArgumentException e) {
                gameOutput.printErrorMessage(e.getMessage());
            }
        }

        Result result = new Result();
        result.calculateResults(lottoTicket, winningNumbers, bonusNumber);
        double yield = purchaseAmount.calculateYield(result.getTotalPrize());
        gameOutput.printResults(result, yield);
    }

    private LottoTicket generateLottoTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(new Lotto(lottoNumbers));
        }
        return new LottoTicket(tickets);
    }
}

