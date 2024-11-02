package lotto.service;

import lotto.model.Lotto;
import lotto.utility.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    // 각 등수별 상금
    private static final Map<Integer, Integer> PRIZES = Map.of(
            6, 2_000_000_000,
            5, 1_500_000,
            4, 50_000,
            3, 5_000
    );

    public List<Lotto> purchaseLottos(int amount) {
        int numberOfLottos = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = LottoNumberGenerator.generate();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    public Map<String, Integer> calculateResults(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        Map<String, Integer> results = new HashMap<>();
        for (Lotto lotto : userLottos) {
            int matchCount = countMatchingNumbers(lotto, winningLotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            String resultKey = getResultKey(matchCount, bonusMatch);
            results.put(resultKey, results.getOrDefault(resultKey, 0) + 1);
        }
        return results;
    }

    private int countMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    private String getResultKey(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return "1등";
        if (matchCount == 5 && bonusMatch) return "2등";
        if (matchCount == 5) return "3등";
        if (matchCount == 4) return "4등";
        if (matchCount == 3) return "5등";
        return "꽝";
    }

    public double calculateProfitRate(Map<String, Integer> results, int totalSpent) {
        int totalWinnings = results.entrySet().stream()
                .mapToInt(entry -> PRIZES.getOrDefault(getMatchCount(entry.getKey()), 0) * entry.getValue())
                .sum();
        return (double) totalWinnings / totalSpent * 100;
    }

    private int getMatchCount(String key) {
        switch (key) {
            case "1등": return 6;
            case "2등": return 5;
            case "3등": return 5;
            case "4등": return 4;
            case "5등": return 3;
            default: return 0;
        }
    }
}
