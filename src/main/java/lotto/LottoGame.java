package lotto;

import java.util.List;
import java.util.Map;
import lotto.system.formater.PrintFormatter;
import lotto.system.formater.winning.LottoWinningAnalyzer;
import lotto.system.formater.winning.WinningStatisticsFormatter;
import lotto.system.lottoGetter.LottoTicketIssuer;
import lotto.system.unit.LottoTicket;
import lotto.system.utils.PrizeType;
import lotto.user.Bonus;
import lotto.user.Lotto;

public class LottoGame {

    public static void start() {

        LottoTicketIssuer ticketIssuer = PrintFormatter.formatPurchaseInfo();
        List<LottoTicket> issuedTickets = ticketIssuer.issueLottoTickets();
        PrintFormatter.formatLottoTickets(issuedTickets);
        Lotto lotto = PrintFormatter.formatWinningNumbers();
        Bonus bonus = PrintFormatter.formatBonusNumber();

        Map<PrizeType, Integer> prizeTypeIntegerMap = LottoWinningAnalyzer.analyzeWinningStatistics(issuedTickets,
                lotto.getNumbers(), bonus.getNumber());
        PrintFormatter.formatResult(
                WinningStatisticsFormatter.formatStatistics(prizeTypeIntegerMap, ticketIssuer.getPurchaseAmount()));
    }
}
