package lotto.system.formater;

import static lotto.system.utils.constants.ViewMessages.BONUS_NUMBER;
import static lotto.system.utils.constants.ViewMessages.LOTTO_TICKET_QUANTITY;
import static lotto.system.utils.constants.ViewMessages.PURCHASE_AMOUNT;
import static lotto.system.utils.constants.ViewMessages.WINNING_NUMBER;

import java.util.List;
import lotto.system.lottoGetter.LottoTicketIssuer;
import lotto.system.unit.LottoTicket;
import lotto.system.utils.Parser;
import lotto.user.Bonus;
import lotto.user.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PrintFormatter {

    public LottoTicketIssuer formatPurchaseInfo() {
        OutputView.printMessage(PURCHASE_AMOUNT.getMessage());
        LottoTicketIssuer lottoTicketIssuer = new LottoTicketIssuer(InputView.inputPurchaseAmount());
        OutputView.printNewLine();

        return lottoTicketIssuer;
    }

    public void formatLottoTickets(List<LottoTicket> lottoTickets, int quantity) {
        OutputView.printMessage(LOTTO_TICKET_QUANTITY.getMessage(quantity));
        lottoTickets.forEach(ticket -> OutputView.printMessage(ticket.toString()));
        OutputView.printNewLine();
    }

    public Lotto formatWinningNumbers() {
        OutputView.printMessage(WINNING_NUMBER.getMessage());
        Lotto winningNumbers = new Lotto(Parser.parseWithDelimiter(InputView.inputWinningNumbers()));
        OutputView.printNewLine();

        return winningNumbers;
    }

    public Bonus formatBonusNumber(List<Integer> winningNumbers) {
        OutputView.printMessage(BONUS_NUMBER.getMessage());
        Bonus bonus = new Bonus(InputView.inputBonusNumber(), winningNumbers);
        OutputView.printNewLine();

        return bonus;
    }

    public void formatResult(String result) {
        OutputView.printMessageWithNewLine(result);
    }
}