package lotto;

import java.util.List;
import lotto.system.utils.Parser;
import lotto.system.lottoGetter.LottoPaymentValidator;
import lotto.system.lottoGetter.LottoTicketIssuer;
import lotto.system.unit.LottoTicket;
import lotto.view.InputView;
import lotto.user.Bonus;
import lotto.user.Lotto;
import lotto.view.OutView;

public class LottoGame {

    public static void start() {

        int money = InputView.inputPurchaseAmount();
        LottoPaymentValidator.validate(money);
        System.out.println();

        LottoTicketIssuer ticketIssuer = new LottoTicketIssuer(money);

        System.out.println(ticketIssuer.getQuantity() + "개를 구매했습니다.");
        ticketIssuer.issueLottoTickets().forEach(ticket -> OutView.printMessagesWithNewLine(ticket.getTicket().toString()));
        System.out.println();

        new Lotto(Parser.parseWithDelimiter(InputView.inputWinningNumbers()));
        System.out.println();

        System.out.println("보너스 볼을 입력해 주세요.");
        new Bonus(InputView.inputBonusNumber());

        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");





        List<LottoTicket> lottoTickets = ticketIssuer.issueLottoTickets();



        ;
    }
}
