package lotto.system.formater;

import java.util.List;
import lotto.system.lottoGetter.LottoTicketIssuer;
import lotto.system.unit.LottoTicket;
import lotto.system.utils.Parser;
import lotto.user.Bonus;
import lotto.user.Lotto;
import lotto.view.InputView;
import lotto.view.InputViewInterface;
import lotto.view.OutPutView;
import lotto.view.OutPutViewInterface;

public class PrintFormatter {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_TICKET_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    
    public LottoTicketIssuer formatPurchaseInfo() {
        OutPutView.printMessage(PURCHASE_AMOUNT_MESSAGE);
        LottoTicketIssuer lottoTicketIssuer = new LottoTicketIssuer(InputView.inputPurchaseAmount());
        OutPutView.printNewLine();

        return lottoTicketIssuer;
    }

    public void formatLottoTickets(List<LottoTicket> lottoTickets, int quantity) {
        OutPutView.printMessage(String.format(LOTTO_TICKET_QUANTITY_MESSAGE, quantity));
        lottoTickets.forEach(ticket -> OutPutView.printMessage(ticket.toString()));
        OutPutView.printNewLine();
    }

    public Lotto formatWinningNumbers() {
        OutPutView.printMessage(WINNING_NUMBER_MESSAGE);
        Lotto winningNumbers = new Lotto(Parser.parseWithDelimiter(InputView.inputWinningNumbers()));
        OutPutView.printNewLine();

        return winningNumbers;
    }

    public Bonus formatBonusNumber() {
        OutPutView.printMessage(BONUS_NUMBER_MESSAGE);
        Bonus bonus = new Bonus(InputView.inputBonusNumber());
        OutPutView.printNewLine();

        return bonus;
    }

    public void formatResult(String result) {
        OutPutView.printMessageWithNewLine(result);
    }
}