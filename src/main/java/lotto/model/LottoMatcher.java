package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatcher {
    private List<List<Integer>> lottoLists;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoMatcher(List<List<Integer>> lottoLists, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoLists = lottoLists;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void matchingLotto(int purchase) {
        Map<Integer, Integer> winningResults = initializeWinningResults();
        Map<Integer, String> winningDetails = initializeWinningDetails();

        for (List<Integer> lottoList : lottoLists) {
            int matchCount = calculateMatchCount(lottoList);
            boolean bonusMatch = lottoList.contains(bonusNumber);

            updateWinningResults(winningResults, matchCount, bonusMatch);
        }

        printWinningResults(winningResults, winningDetails);
        totalWinningRate(purchase, winningResults, winningDetails);
    }

    private int calculateMatchCount(List<Integer> lottoList) {
        int matchCount = 0;
        for (int num : lottoList) {
            if (winningNumbers.contains(num)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private void updateWinningResults(Map<Integer, Integer> winningResults, int matchCount, boolean bonusMatch) {
        if (matchCount < 3) {
            return; // 3개 미만 일치 시 아무 작업도 하지 않음
        }

        if (matchCount == 5 && bonusMatch) {
            winningResults.put(7, winningResults.get(7) + 1); // 5개 + 보너스 일치
            return;
        }

        winningResults.put(matchCount, winningResults.get(matchCount) + 1);
    }

    private void printWinningResults(Map<Integer, Integer> winningResults, Map<Integer, String> winningDetails) {
        for (int key : winningResults.keySet()) {
            if (key == 6) {
                System.out.println("5개 일치, 보너스 볼 일치 (" + winningDetails.get(key) + "원) - " + winningResults.get(key) + "개");
                continue;
            }

            if (key == 7) {
                System.out.println("6개 일치 (" + winningDetails.get(key) + "원) - " + winningResults.get(key) + "개");
                continue;
            }

            System.out.println(key + "개 일치 (" + winningDetails.get(key) + "원) - " + winningResults.get(key) + "개");
        }
    }

    private void totalWinningRate(int purchase, Map<Integer, Integer> winningResults, Map<Integer, String> winningDetails) {
        long totalPrice = 0;

        for (int key : winningResults.keySet()) {
            if (winningResults.get(key) != 0) {
                totalPrice += Long.parseLong(winningDetails.get(key).replace(",", ""));
            }
        }

        float winningRate = (float) totalPrice / purchase * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", winningRate);
    }

    private Map<Integer, Integer> initializeWinningResults() {
        Map<Integer, Integer> winningResults = new HashMap<>();
        for (int i = 3; i <= 7; i++) {
            winningResults.put(i, 0);
        }
        return winningResults;
    }

    private Map<Integer, String> initializeWinningDetails() {
        Map<Integer, String> winningDetails = new HashMap<>();
        winningDetails.put(3, "5,000");
        winningDetails.put(4, "50,000");
        winningDetails.put(5, "1,500,000");
        winningDetails.put(6, "30,000,000");
        winningDetails.put(7, "2,000,000,000");
        return winningDetails;
    }
}
