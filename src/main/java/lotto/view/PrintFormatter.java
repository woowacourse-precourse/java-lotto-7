package lotto.view;

import static lotto.view.InputView.inputPurchaseAmount;
import static lotto.view.OutputView.displayBonusNumberPrompt;
import static lotto.view.OutputView.displayLottoTickets;
import static lotto.view.OutputView.displayPurchasePrompt;
import static lotto.view.OutputView.displayResult;
import static lotto.view.OutputView.displayTicketQuantity;
import static lotto.view.OutputView.displayWinningNumberPrompt;
import static lotto.view.OutputView.printNewLine;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.value.LottoTicket;
import lotto.service.lotto.LottoTicketIssuer;
import lotto.utils.Parser;

public class PrintFormatter {

    public LottoTicketIssuer handlePurchaseInfo() {
        LottoTicketIssuer lottoTicketIssuer = null;
        displayPurchasePrompt();
        while (lottoTicketIssuer == null) {
            try {
                int purchaseAmount = inputPurchaseAmount();
                lottoTicketIssuer = createLottoTicketIssuer(purchaseAmount);
                printNewLine();
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
        return lottoTicketIssuer;
    }

    public Lotto handleWinningNumbers() {
        Lotto winningNumbers = null;
        displayWinningNumberPrompt();
        while (winningNumbers == null) {
            try {
                String winningNumbersInput = InputView.inputWinningNumbers();
                winningNumbers = createLottoFromInput(winningNumbersInput);
                printNewLine();
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
        return winningNumbers;
    }

    public Bonus handleBonusNumber(List<Integer> winningNumbers) {
        Bonus bonus = null;
        displayBonusNumberPrompt();
        while (bonus == null) {
            try {
                int bonusNumber = InputView.inputBonusNumber();
                bonus = createBonusFromInput(bonusNumber, winningNumbers);
                printNewLine();
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
        return bonus;
    }

    public void displayLottoTicketsWithQuantity(List<LottoTicket> lottoTickets, int quantity) {
        displayTicketQuantity(quantity);
        displayLottoTickets(lottoTickets);
    }

    public void displayResultWithNewLine(String result) {
        displayResult(result);
    }

    private LottoTicketIssuer createLottoTicketIssuer(int purchaseAmount) {
        return new LottoTicketIssuer(purchaseAmount);
    }

    private Lotto createLottoFromInput(String input) {
        return new Lotto(Parser.parseWithDelimiter(input));
    }

    private Bonus createBonusFromInput(int bonusNumber, List<Integer> winningNumbers) {
        return new Bonus(bonusNumber, winningNumbers);
    }
}