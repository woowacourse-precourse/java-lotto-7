package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoChecker;
import lotto.model.LottoMachine;
import lotto.model.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoChecker lottoChecker = new LottoChecker();

    public void run() {
        int purchaseAmount = getValidatedPurchaseAmount();
        int ticketCount = purchaseAmount / 1000;

        List<Lotto> tickets = lottoMachine.generateLottoTickets(ticketCount);
        ResultView.printLottoTickets(tickets);

        List<Integer> winningNumbers = getValidatedWinningNumbers();
        int bonusNumber = getValidatedBonusNumber();
    }

    private int getValidatedPurchaseAmount() {
        while (true) {
            try {
                return InputView.getPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                return InputView.getWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidatedBonusNumber() {
        while (true) {
            try {
                return InputView.getBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
