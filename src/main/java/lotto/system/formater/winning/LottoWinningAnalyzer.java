package lotto.system.formater.winning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.system.utils.PrizeType;
import lotto.system.unit.LottoTicket;
import lotto.system.unit.LottoNumber;

public class LottoWinningAnalyzer {

    public static Map<PrizeType, Integer> analyzeWinningStatistics(
            List<LottoTicket> issueTickets,
            List<Integer> winningNumbers,
            int bonusNumber) {

        Map<PrizeType, Integer> statistics = new HashMap<>();

        for (PrizeType prizeType : PrizeType.values()) {
            statistics.put(prizeType, 0);
        }

        for (LottoTicket issueTicket : issueTickets) {
            PrizeType prizeType = match(issueTicket, winningNumbers, bonusNumber);
            if (prizeType == null) {
                continue;
            }
            statistics.put(prizeType, statistics.get(prizeType) + 1);
        }

        return statistics;
    }

    public static PrizeType match(
            LottoTicket issueTicket,
            List<Integer> winningNumbers,
            int bonusNumber) {

        int count = matchLotto(issueTicket, winningNumbers);
        boolean matchBonus = matchBonus(issueTicket, bonusNumber);

        if (matchBonus && count == 5) {
            return PrizeType.getTypeByCode(6);
        }
        else if (count == 6) {
            return PrizeType.getTypeByCode(7);
        }
        else if (count >= 3) {
            return PrizeType.getTypeByCode(count);
        } else {
            return null;
        }
    }

    public static int matchLotto(LottoTicket issueTicket, List<Integer> winningNumbers) {
        int count = 0;
        for (LottoNumber number : issueTicket.getTicket()) {
            if (winningNumbers.contains(number.getValue())) {
                count++;
            }
        }

        return count;
    }

    public static boolean matchBonus(LottoTicket issueTicket, int bonusNumber) {
        return issueTicket.getTicket().stream().anyMatch(number -> number.getValue() == bonusNumber);
    }
}