package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultChecker {

    private static final Map<Integer, Integer> prizeMap = new HashMap<>() {{
        put(6, 2_000_000_000);   // 1등
        put(5, 1_500_000);       // 3등
        put(4, 50_000);          // 4등
        put(3, 5_000);           // 5등
    }};

    public static Map<Integer, Integer> checkLottoResults(List<Lotto> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        int firstPrizeCount = 0;
        int secondPrizeCount = 0;
        Map<Integer, Integer> resultCounts = new HashMap<>();

        // 초기화
        for (int matchCount : prizeMap.keySet()) {
            resultCounts.put(matchCount, 0);
        }

        // 각 로또의 일치 개수를 계산
        for (Lotto lotto : userLottos) {
            int matchCount = calculateMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                firstPrizeCount++;
            } else if (matchCount == 5 && bonusMatch) {
                secondPrizeCount++;
            } else if (matchCount >= 3) {
                resultCounts.put(matchCount, resultCounts.get(matchCount) + 1);
            }
        }

        // 결과 출력
        printResults(resultCounts, firstPrizeCount, secondPrizeCount);

        // 수익률 계산에 필요한 당첨 결과 반환
        resultCounts.put(6, firstPrizeCount);
        resultCounts.put(5, resultCounts.get(5) + secondPrizeCount); // 2등은 5등과 별도로 구분
        return resultCounts;
    }

    public static int calculateMatchCount(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static void printResults(Map<Integer, Integer> resultCounts, int firstPrizeCount, int secondPrizeCount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", resultCounts.getOrDefault(3, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", resultCounts.getOrDefault(4, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", resultCounts.getOrDefault(5, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", secondPrizeCount);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", firstPrizeCount);
    }
}