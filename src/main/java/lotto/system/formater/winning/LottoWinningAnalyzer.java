package lotto.system.formater.winning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.system.utils.PrizeType;
import lotto.system.unit.LottoTicket;
import lotto.system.unit.LottoNumber;

public class LottoWinningAnalyzer {

    public static Map<PrizeType, Integer> analyzeWinningStatistics(LottoTicket winningTicket, List<LottoTicket> tickets, LottoNumber bonusNumber) {
        Map<PrizeType, Integer> statistics = new HashMap<>();

        for (PrizeType prizeType : PrizeType.values()) {
            statistics.put(prizeType, 0);
        }

        for (LottoTicket ticket : tickets) {
            PrizeType prizeType = match(winningTicket, ticket, bonusNumber);
            statistics.put(prizeType, statistics.get(prizeType) + 1);
        }

        return statistics;
    }

    public static PrizeType match(LottoTicket winningTicket, LottoTicket ticket, LottoNumber bonusNumber) {
        int count = matchLotto(winningTicket, ticket);
        boolean matchBonus = matchBonus(bonusNumber, ticket);

        if (matchBonus && count == 5) {
            return PrizeType.getTypeByCode(6);
        }
        else if (count == 6) {
            return PrizeType.getTypeByCode(7);
        }
        else {
            return PrizeType.getTypeByCode(count);
        }
    }

    public static int matchLotto(LottoTicket winningTicket, LottoTicket ticket) {
        int count = 0;
        for (LottoNumber number : ticket.getTicket()) {
            if (winningTicket.getTicket().contains(number)) {
                count++;
            }
        }

        return count;
    }

    public static boolean matchBonus(LottoNumber bonusNumber, LottoTicket ticket) {
        return ticket.getTicket().contains(bonusNumber);
    }
}
