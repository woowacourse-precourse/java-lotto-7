package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<WinningPrize, Integer> results;

    public LottoResult() {
        results = new EnumMap<>(WinningPrize.class);
        initializeResults();
    }

    private void initializeResults() {
        for (WinningPrize winningPrize : WinningPrize.values()) {
            if (winningPrize != WinningPrize.NONE_PRIZE) {
                results.put(winningPrize, 0);
            }
        }
    }


    public void calculateResult(Lottos lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos.getLottos()) {
            WinningPrize winningPrize = calculateWinningPrize(lotto, winningNumbers);
            if (winningPrize != WinningPrize.NONE_PRIZE) {
                addResult(winningPrize);
            }
        }
    }

    private WinningPrize calculateWinningPrize(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = winningNumbers.countMatchNumbers(lotto);
        boolean matchBonus = winningNumbers.matchBonus(lotto);
        return WinningPrize.valueOf(matchCount, matchBonus);
    }

    private void addResult(WinningPrize winningPrize) {
        results.put(winningPrize, results.get(winningPrize) + 1);
    }
    public double calculateReturnRate(long purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        return Math.round((double) totalPrize / purchaseAmount * 1000) / 10.0;
    }

    private long calculateTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<WinningPrize, Integer> entry : results.entrySet()) {
            WinningPrize prize = entry.getKey();
            int count = entry.getValue();
            totalPrize += (long) prize.getPrize() * count;
        }
        return totalPrize;
    }




}