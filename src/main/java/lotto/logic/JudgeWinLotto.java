package lotto.logic;

import lotto.input.InputValidationMessage;

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
    private static final int SECOND_PRIZE = 30000000;
    private static final int FIRST_PRIZE = 2000000000;

    public static void calculateResults(List<List<Integer>> lottoNumbersList, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {

        if (lottoNumbersList == null || winningNumbers == null || lottoNumbersList.isEmpty() || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(InputValidationMessage.MESSAGE_NUMBER_CANNOT_NULL.getMessage());
        }

        Map<Integer, Integer> matchCountMap = new HashMap<>();
        int totalPrize = 0;

        totalPrize = countMatches(lottoNumbersList, winningNumbers, bonusNumber, totalPrize, matchCountMap);

        System.out.println("당첨 통계");
        System.out.println("---");

        printStatistics(matchCountMap);

        printRateOfReturn(purchaseAmount, totalPrize);
    }

    private static int countMatches(List<List<Integer>> lottoNumbersList, List<Integer> winningNumbers, int bonusNumber, int totalPrize, Map<Integer, Integer> matchCountMap) {
        for (List<Integer> lottoNumbers : lottoNumbersList) {
            int matchCount = getMatchCount(lottoNumbers, winningNumbers);
            boolean bonusMatch = lottoNumbers.contains(bonusNumber);

            totalPrize = judgementCountMatches(totalPrize, matchCountMap, matchCount, bonusMatch);
        }
        return totalPrize;
    }

    private static int judgementCountMatches(int totalPrize, Map<Integer, Integer> matchCountMap, int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            totalPrize += FIRST_PRIZE;
            matchCountMap.put(6, matchCountMap.getOrDefault(6, 0) + 1);
        }

        if (matchCount == 5 && bonusMatch) {
            totalPrize += SECOND_PRIZE;
            matchCountMap.put(55, matchCountMap.getOrDefault(55, 0) + 1);
        }

        if (PRIZE_MAP.containsKey(matchCount)) {
            int prize = PRIZE_MAP.get(matchCount);
            totalPrize += prize;
            matchCountMap.put(matchCount, matchCountMap.getOrDefault(matchCount, 0) + 1);
        }
        return totalPrize;
    }

    private static void printStatistics(Map<Integer, Integer> matchCountMap) {
        int[] matchOrder = {3, 4, 5, 55, 6};
        for (int i : matchOrder) {
            int count = matchCountMap.getOrDefault(i, 0);
            int prize = (i == 55) ? SECOND_PRIZE : PRIZE_MAP.getOrDefault(i, 0);
            String matchText = (i == 55) ? "5개 일치, 보너스 볼 일치" : i + "개 일치";
            System.out.printf("%s (%,d원) - %d개%n", matchText, prize, count);
        }
    }

    private static void printRateOfReturn(int purchaseAmount, int totalPrize) {
        double yield = calculateYield(totalPrize, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            matchCount = getMatchCount(winningNumbers, number, matchCount);
        }
        return matchCount;
    }

    private static int getMatchCount(List<Integer> winningNumbers, int number, int matchCount) {
        if (winningNumbers.contains(number)) {
            matchCount++;
        }
        return matchCount;
    }

    private static double calculateYield(int totalPrize, int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0;
        }
        return (double) totalPrize / (purchaseAmount) * 100;
    }
}
