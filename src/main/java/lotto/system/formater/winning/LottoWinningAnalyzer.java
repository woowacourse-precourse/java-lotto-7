package lotto.system.formater.winning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.system.unit.LottoTicket;
import lotto.system.utils.PrizeType;

public class LottoWinningAnalyzer {

    private static final int MATCH_SIX = 6;
    private static final int MATCH_FIVE_WITH_BONUS = 5;
    private static final int MINIMUM_MATCH = 3;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningAnalyzer(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<PrizeType, Integer> analyzeWinningStatistics(List<LottoTicket> issueTickets) {
        Map<PrizeType, Integer> statistics = initializeStatistics();

        for (LottoTicket issueTicket : issueTickets) {
            PrizeType prizeType = determinePrizeType(issueTicket);
            if (prizeType != null) {
                statistics.put(prizeType, statistics.get(prizeType) + 1);
            }
        }

        return statistics;
    }

    private Map<PrizeType, Integer> initializeStatistics() {
        Map<PrizeType, Integer> statistics = new HashMap<>();
        for (PrizeType prizeType : PrizeType.values()) {
            statistics.put(prizeType, 0);
        }
        return statistics;
    }

    private PrizeType determinePrizeType(LottoTicket issueTicket) {
        int matchCount = countMatchingNumbers(issueTicket);
        boolean hasBonusMatch = hasBonusNumberMatch(issueTicket);

        if (hasBonusMatch && matchCount == MATCH_FIVE_WITH_BONUS) {
            return PrizeType.getTypeByCode(6);
        }
        if (matchCount == MATCH_SIX) {
            return PrizeType.getTypeByCode(7);
        }
        if (matchCount >= MINIMUM_MATCH) {
            return PrizeType.getTypeByCode(matchCount);
        }
        return null;
    }

    protected int countMatchingNumbers(LottoTicket issueTicket) {
        return (int) issueTicket.getTicket().stream()
                .filter(number -> winningNumbers.contains(number.getValue()))
                .count();
    }

    protected boolean hasBonusNumberMatch(LottoTicket issueTicket) {
        return issueTicket.getTicket().stream()
                .anyMatch(number -> number.getValue() == bonusNumber);
    }
}