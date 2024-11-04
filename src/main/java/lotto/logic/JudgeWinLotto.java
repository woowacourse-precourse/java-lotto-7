package lotto.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JudgeWinLotto {
    private static final Map<Integer, Integer> PRIZE_MAP = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );
    private static final int SECOND_PRIZE = 30000000; // 5개 + 보너스 볼 일치 시 상금
    private static final int FIRST_PRIZE = 2000000000; // 6개 일치 시 상금

    public static void calculateResults(List<List<Integer>> lottoNumbersList, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        if (lottoNumbersList == null || winningNumbers == null || lottoNumbersList.isEmpty() || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 목록과 당첨 번호는 비어 있거나 null일 수 없습니다.");
        }

        Map<Integer, Integer> matchCountMap = new HashMap<>();
        int totalPrize = 0;

        for (List<Integer> lottoNumbers : lottoNumbersList) {
            int matchCount = getMatchCount(lottoNumbers, winningNumbers);
            boolean bonusMatch = lottoNumbers.contains(bonusNumber);

            if (matchCount == 6) {
                totalPrize += FIRST_PRIZE;
                matchCountMap.put(6, matchCountMap.getOrDefault(6, 0) + 1);
            } else if (matchCount == 5 && bonusMatch) {
                totalPrize += SECOND_PRIZE;
                matchCountMap.put(55, matchCountMap.getOrDefault(55, 0) + 1);
            } else if (PRIZE_MAP.containsKey(matchCount)) {
                int prize = PRIZE_MAP.get(matchCount);
                totalPrize += prize;
                matchCountMap.put(matchCount, matchCountMap.getOrDefault(matchCount, 0) + 1);
            }
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        int[] matchOrder = {3, 4, 5, 55, 6};
        for (int i : matchOrder) {
            int count = matchCountMap.getOrDefault(i, 0);
            int prize = (i == 55) ? SECOND_PRIZE : PRIZE_MAP.getOrDefault(i, 0);
            String matchText = (i == 55) ? "5개 일치, 보너스 볼 일치" : i + "개 일치";
            System.out.printf("%s (%,d원) - %d개%n", matchText, prize, count);
        }

        double yield = calculateYield(totalPrize, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static double calculateYield(int totalPrize, int purchaseAmount) {
        if (purchaseAmount == 0) return 0;
        double yield = (double) totalPrize / purchaseAmount * 100;
        return Math.round(yield * 10) / 10.0;
    }
}
