package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatcher {
    List<List<Integer>> lottoLists;
    List<Integer> winningNumbers;
    int bonusNumber;

    public LottoMatcher(List<List<Integer>> lottoLists, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoLists = lottoLists;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static void matchingLotto(List<List<Integer>> lottoLists, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> winningResults = winningResults();
        for (List<Integer> lottoList : lottoLists) {
            int matchCount = 0;
            boolean bonusMatch = false;

            for (int num : lottoList) {
                if (winningNumbers.contains(num)) {
                    matchCount++;
                }
                if (num == bonusNumber) {
                    bonusMatch = true;
                }
            }

            if (matchCount >= 3) {
                if (matchCount == 5 && bonusMatch) {
                    winningResults.put(7, winningResults.get(7) + 1);
                }
                winningResults.put(matchCount, winningResults.get(matchCount) + 1);
            }


        }

        for (int key : winningResults.keySet()) {
            if (key == 6) {
                System.out.println(key + "개 일치, 보너스 볼 일치 (" + winningDetails().get(key) + ") - " + winningResults.get(key) + "개");
                continue;
            }
            System.out.println(key + "개 일치 (" + winningDetails().get(key) + ") - " + winningResults.get(key) + "개");
        }
    }

    public static Map<Integer, Integer> winningResults() {
        Map<Integer, Integer> winningResults = new HashMap<>();

        for (int i = 3; i < 8; i++) {
            winningResults.put(i, 0);
        }

        return winningResults;
    }

    public static Map<Integer, String> winningDetails() {
        Map<Integer, String> winningDetails = new HashMap<>();

        winningDetails.put(3, "5,000");
        winningDetails.put(4, "50,000");
        winningDetails.put(5, "1,500,000");
        winningDetails.put(6, "30,000,000");
        winningDetails.put(7, "2,000,000,000");

        return winningDetails;
    }

}
