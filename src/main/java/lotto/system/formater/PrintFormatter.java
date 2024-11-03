package lotto.system.formater;

import java.util.List;
import lotto.system.lottoGetter.LottoTicketIssuer;
import lotto.system.unit.LottoTicket;
import lotto.system.utils.Parser;
import lotto.user.Bonus;
import lotto.user.Lotto;
import lotto.view.InputView;
import lotto.view.OutView;

public class PrintFormatter {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static LottoTicketIssuer formatPurchaseInfo() {
        OutView.printMessage(PURCHASE_AMOUNT_MESSAGE);
        return new LottoTicketIssuer(InputView.inputPurchaseAmount());
    }

    public static void formatLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets
                .forEach(System.out::println);
    }

    public static Lotto formatWinningNumbers() {
        OutView.printMessage(WINNING_NUMBER_MESSAGE);
        return new Lotto(Parser.parseWithDelimiter(InputView.inputWinningNumbers()));
    }

    public static Bonus formatBonusNumber() {
        OutView.printMessage(BONUS_NUMBER_MESSAGE);
        return new Bonus(InputView.inputBonusNumber());
    }

    public static void formatResult(String result) {
        OutView.printMessageWithNewLine(result);
    }
}
