package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottery;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoResultService {
    public static final String KEY_1ST = "1st";
    public static final String KEY_2ND = "2nd";
    public static final String KEY_3RD = "3rd";
    public static final String KEY_4TH = "4th";
    public static final String KEY_5TH = "5th";

    public Map<String, Integer> calculateResults(List<Lotto> purchasedLottos, Lottery lottery) {
        Map<String, Integer> results = new HashMap<>();

        results.put(KEY_1ST, 0);
        results.put(KEY_2ND, 0);
        results.put(KEY_3RD, 0);
        results.put(KEY_4TH, 0);
        results.put(KEY_5TH, 0);

        for (Lotto purchasedLotto : purchasedLottos) {
            int matchingCount = countMatchingNumbers(purchasedLotto.getNumbers(), lottery.getWinningLotto().getNumbers());
            boolean bonusMatch = purchasedLotto.getNumbers().contains(lottery.getBonusNumber());

            String prize = getPrize(matchingCount, bonusMatch);
            if (prize != null) {
                results.put(prize, results.get(prize) + 1);
            }
        }
        return results;
    }

    public static final Map<String, Integer> PRIZES = Map.of(
            KEY_1ST, 2_000_000_000,
            KEY_2ND, 30_000_000,
            KEY_3RD, 1_500_000,
            KEY_4TH, 50_000,
            KEY_5TH, 5_000
    );

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        long count = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        return (int)count ;
    }

    private String getPrize(int matchingCount, boolean bonusMatch) {
        if (matchingCount == 6) {
            return KEY_1ST;
        } else if (matchingCount == 5 && bonusMatch) {
            return KEY_2ND;
        } else if (matchingCount == 5) {
            return KEY_3RD;
        } else if (matchingCount == 4) {
            return KEY_4TH;
        } else if (matchingCount == 3) {
            return KEY_5TH;
        }
        return null;
    }
}