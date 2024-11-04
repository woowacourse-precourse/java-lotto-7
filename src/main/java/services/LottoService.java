package services;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import model.Lotto;

public class LottoService {

    public List<Lotto> generateLotto(String purchaseAmount) {
        int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);
        int lottoCount = parsedPurchaseAmount / 1000;

        return IntStream.range(0, lottoCount)
                .mapToObj(count -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }

    public Map<Integer, Integer> findMatchLotto(String winningNumbers, String bonusNumber, List<Lotto> lottos) {
        List<Integer> parseWinningNumbers = parseWinningNumbers(winningNumbers);
        int parseBonusNumber = parseBonusNumber(bonusNumber);

        Map<Integer, Integer> matchCounts = initializeMatchCounts();

        lottos.forEach(lotto -> {
            int matchCount = lotto.countMatchingNumbers(parseWinningNumbers);
            boolean isBonusMatch = lotto.containsBonusNumber(parseBonusNumber);

            updateMatchCounts(matchCounts, matchCount, isBonusMatch);
        });
        return matchCounts;
    }

    private void updateMatchCounts(Map<Integer, Integer> matchCounts, int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch) {
            matchCounts.put(-5, matchCounts.get(-5) + 1);
            return;
        }

        if (matchCount == 5) {
            matchCounts.put(5, matchCounts.get(5) + 1);
            return;
        }

        if (matchCount >= 3) {
            matchCounts.put(matchCount, matchCounts.get(matchCount) + 1);
        }
    }

    private Map<Integer, Integer> initializeMatchCounts() {
        Map<Integer, Integer> matchCounts = new HashMap<>();
        for (int count = 3; count <= 6; count++) {
            matchCounts.put(count, 0);
        }
        matchCounts.put(-5, 0);
        return matchCounts;
    }

    private int parseBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    private List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public double calculateYield(Map<Integer, Integer> lottoMatches, String purchaseAmount) {
        int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);
        int totalPrize = lottoMatches.get(3) * 5_000 + lottoMatches.get(4) * 50_000
                + lottoMatches.get(5) * 1_500_000 + lottoMatches.get(-5) * 30_000_000
                + lottoMatches.get(6) * 2_000_000_000;

        return (double) totalPrize / parsedPurchaseAmount * 100;
    }
}
