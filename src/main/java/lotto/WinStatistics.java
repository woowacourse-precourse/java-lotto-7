package lotto;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class WinStatistics {
    private final Map<Integer, Integer> winResults = new HashMap<>();

    public WinStatistics() {
        // 초기 당첨 내역을 0으로 초기화
        winResults.put(6, 0); // 6개 일치
        winResults.put(5, 0); // 5개 + 보너스 일치
        winResults.put(4, 0); // 5개 일치
        winResults.put(3, 0); // 4개 일치
        winResults.put(2, 0); // 3개 일치
    }

    public void calculateWinStatistics(List<Lotto> tickets, WinningChecker winningChecker) {
        for (Lotto ticket : tickets) {
            int winCategory = winningChecker.checkWinning(ticket);
            if (winCategory >= 2) {
                winResults.put(winCategory, winResults.get(winCategory) + 1);
            }
        }
    }

    public Map<Integer, Integer> getWinResults() {
        return winResults;
    }
}
