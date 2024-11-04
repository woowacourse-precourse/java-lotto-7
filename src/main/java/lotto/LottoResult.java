package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final Map<Integer, Integer> PRIZE_MAP = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6,2000000000
    );
    private static final int BONUS_PRIZE = 30000000;
    private final Map<Integer, Integer> matchCounts = new HashMap<>();
    private int bonusMatchCount =0;



    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber){
        for (int i =0; i<=6; i++){
            matchCounts.put(i,0);
        }
        validateWinningNumbers(winningNumbers, bonusNumber);
        recordMatches(lottos, winningNumbers, bonusNumber);
    }
    private void recordMatches(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            recordMatch(matchCount, bonusMatch);
        }
    }
    public void recordMatch(int matchCount, boolean bonusMatch) {
        if (matchCount >= 3 && matchCount <= 6) {
            matchCounts.put(matchCount, matchCounts.get(matchCount) + 1);
            if (bonusMatch && matchCount == 5) {
                bonusMatchCount++;
            }
        }
    }
    public int getCountOfMatches(int matchCount){
        return matchCounts.getOrDefault(matchCount,0);
    }
    public int getCountOfMatches(int matchCount, boolean bonusMatch){
        return (matchCount == 5 && bonusMatch) ? bonusMatchCount : getCountOfMatches(matchCount);

    }
    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = matchCounts.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * PRIZE_MAP.getOrDefault(entry.getKey(), 0))
                .sum() + bonusMatchCount * BONUS_PRIZE;
        return (double) totalPrize / purchaseAmount * 100;
    }
    private void validateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
