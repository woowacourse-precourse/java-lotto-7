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
import lotto.service.lotto.LottoTicketIssuer;
import lotto.domain.value.LottoTicket;
import lotto.utils.Parser;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.view.InputView;

public class PrintFormatter {

    public LottoTicketIssuer handlePurchaseInfo() {
        displayPurchasePrompt();
        int purchaseAmount = inputPurchaseAmount();
        LottoTicketIssuer lottoTicketIssuer = createLottoTicketIssuer(purchaseAmount);
        printNewLine();
        return lottoTicketIssuer;
    }

    public void displayLottoTicketsWithQuantity(List<LottoTicket> lottoTickets, int quantity) {
        displayTicketQuantity(quantity);
        displayLottoTickets(lottoTickets);
    }

    public Lotto handleWinningNumbers() {
        displayWinningNumberPrompt();
        String winningNumbersInput = InputView.inputWinningNumbers();
        Lotto winningNumbers = createLottoFromInput(winningNumbersInput);
        printNewLine();
        return winningNumbers;
    }

    public Bonus handleBonusNumber(List<Integer> winningNumbers) {
        displayBonusNumberPrompt();
        int bonusNumber = InputView.inputBonusNumber();
        Bonus bonus = createBonusFromInput(bonusNumber, winningNumbers);
        printNewLine();
        return bonus;
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