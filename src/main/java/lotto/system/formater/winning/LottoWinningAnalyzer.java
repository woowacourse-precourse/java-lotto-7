package lotto.system.formater.winning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.system.utils.PrizeType;
import lotto.system.unit.LottoTicket;
import lotto.system.unit.LottoNumber;

public class LottoWinningAnalyzer {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningAnalyzer(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<PrizeType, Integer> analyzeWinningStatistics(List<LottoTicket> issueTickets) {
        Map<PrizeType, Integer> statistics = new HashMap<>();

        for (PrizeType prizeType : PrizeType.values()) {
            statistics.put(prizeType, 0);
        }

        for (LottoTicket issueTicket : issueTickets) {
            PrizeType prizeType = match(issueTicket);
            if (prizeType == null) {
                continue;
            }
            statistics.put(prizeType, statistics.get(prizeType) + 1);
        }

        return statistics;
    }

    private PrizeType match(LottoTicket issueTicket) {
        int count = matchLotto(issueTicket);
        boolean matchBonus = matchBonus(issueTicket);

        if (matchBonus && count == 5) {
            return PrizeType.getTypeByCode(6);
        } else if (count == 6) {
            return PrizeType.getTypeByCode(7);
        } else if (count >= 3) {
            return PrizeType.getTypeByCode(count);
        } else {
            return null;
        }
    }

    private int matchLotto(LottoTicket issueTicket) {
        int count = 0;
        for (LottoNumber number : issueTicket.getTicket()) {
            if (winningNumbers.contains(number.getValue())) {
                count++;
            }
        }
        return count;
    }

    private boolean matchBonus(LottoTicket issueTicket) {
        return issueTicket.getTicket().stream().anyMatch(number -> number.getValue() == bonusNumber);
    }
}