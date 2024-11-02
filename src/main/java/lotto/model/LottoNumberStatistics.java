package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoNumberStatistics {

    private static final String TOTAL_RETURN_RATE = "TOTAL_RETURN_RATE";
    private static final int LOTTO_PRICE = 1000;

    public HashMap<String, String> checkWinner(List<Lotto> lotteryTickets,
        HashMap<Integer, String> winnerNumbers) {
        HashMap<LottoRank, Integer> winningCount = initializeWinningCount();
        long totalPrize = 0;
        for (Lotto ticket : lotteryTickets) {
            Map<String, Integer> matchResult = matchNumber(ticket, winnerNumbers);
            LottoRank rank = LottoRank.getRank(matchResult.get("matchCount"),
                matchResult.get("matchBonus") == 1);
            if (rank != LottoRank.NONE) {
                winningCount.put(rank, winningCount.get(rank) + 1);
                totalPrize += rank.getPrize();
            }
        }
        return calculateResults(winningCount, totalPrize, lotteryTickets.size());
    }

    private HashMap<LottoRank, Integer> initializeWinningCount() {
        HashMap<LottoRank, Integer> winningCount = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                winningCount.put(rank, 0);
            }
        }
        return winningCount;
    }

    private Map<String, Integer> matchNumber(Lotto ticket, HashMap<Integer, String> winnerNumbers) {
        List<Integer> winningNumbers = getWinningNumbers(winnerNumbers);
        int bonusNumber = getBonusNumber(winnerNumbers);
        int matchCount = (int) ticket.getNumbers().stream()
            .filter(winningNumbers::contains)
            .count();
        int matchBonus = 0;
        if (ticket.getNumbers().contains(bonusNumber)) {
            matchBonus = 1;
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("matchCount", matchCount);
        result.put("matchBonus", matchBonus);
        return result;
    }

    private List<Integer> getWinningNumbers(HashMap<Integer, String> winnerNumbers) {
        return winnerNumbers.entrySet().stream()
            .filter(entry -> "winningNumber".equals(entry.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    private int getBonusNumber(HashMap<Integer, String> winnerNumbers) {
        return winnerNumbers.entrySet().stream()
            .filter(entry -> "bonusNumber".equals(entry.getValue()))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(0);
    }

    private HashMap<String, String> calculateResults(HashMap<LottoRank, Integer> winningCount,
        long totalPrize, int totalTickets) {
        HashMap<String, String> results = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                results.put(rank.name(), winningCount.get(rank).toString());
            }
        }
        double returnRate = (double) totalPrize / (totalTickets * LOTTO_PRICE) * 100;
        results.put(TOTAL_RETURN_RATE, String.format("%.1f", returnRate));
        return results;
    }
}