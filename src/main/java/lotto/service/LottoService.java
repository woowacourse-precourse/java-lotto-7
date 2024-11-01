package lotto.service;

import lotto.domain.Lotto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final List<Integer> WINNING_PRIZES = List.of(0, 0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000);

    public List<Integer> sortLottoNumbersAscending(List<Integer> lottoNumber) {
        for (int i = 0; i < lottoNumber.size() - 1; i++) {
            for (int j = 0; j < lottoNumber.size() - i - 1; j++) {
                lottoNumber = swap(j, j + 1, lottoNumber);
            }
        }
        return lottoNumber;
    }

    private List<Integer> swap(int idx1, int idx2, List<Integer> arr) {
        if (arr.get(idx1) > arr.get(idx2)) {
            int tmp = arr.get(idx1);
            arr.set(idx1, arr.get(idx2));
            arr.set(idx2, tmp);
        }
        return arr;
    }

    public int calculateLottoQuantities(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public int matchingWinningNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer num : lottoNumbers) {
            if (winningNumbers.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public Map<Integer, Integer> getMatchingCounts(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> matchingCounts = new HashMap<>() {{
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
            put(7, 0);
        }};
        for (Lotto lotto : lottos) {
            int matchingCount = lotto.getMatchingCount(winningNumbers, bonusNumber);
            matchingCounts.put(matchingCount, matchingCounts.get(matchingCount) + 1);
        }
        return matchingCounts;
    }

    public int sumOfPrizes(Map<Integer, Integer> matchingCounts) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : matchingCounts.entrySet()) {
            int matchCount = entry.getKey();
            int prizeCount = entry.getValue();
            sum += WINNING_PRIZES.get(matchCount) * prizeCount;
        }
        return sum;
    }

    public double calculateReturn(int sum, int purchaseAmount) {
        return sum / purchaseAmount * 100;
    }
}
