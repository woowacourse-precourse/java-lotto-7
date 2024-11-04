package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.Prize;

public class LottoResultChecker {
    private WinningNumbers winningNumbers;

    public LottoResultChecker(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Map<Prize, Integer> getLottosWinningResult(Lottos lottos) {
        Map<Prize, Integer> prizeCount = initializePrizeCount();

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = getMatchCount(lotto.getNumbers());
            boolean hasBonus = hasBonusNumber(lotto.getNumbers());
            addPrizeIfEligible(matchCount, hasBonus, prizeCount);
        }
        return prizeCount;
    }

    public double getYield(Map<Prize, Integer> prizeCount, Lottos lottos) {
        int purchaseAmount = lottos.getCount() * 1000;
        long totalPrize = prizeCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }

    private void addPrizeIfEligible(int matchCount, boolean hasBonus, Map<Prize, Integer> prizeCount) {
        if (matchCount >= 3) {
            Prize prize = Prize.findPrize(matchCount, hasBonus);
            prizeCount.put(prize, prizeCount.getOrDefault(prize, 0) + 1);
        }
    }

    private int getMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(this::isNumberInWinningNumbers)
                .count();
    }

    private boolean isNumberInWinningNumbers(int number) {
        return winningNumbers.getNumbers().contains(number);
    }

    private Map<Prize, Integer> initializePrizeCount() {
        Map<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
        return prizeCount;
    }

    private boolean hasBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(winningNumbers.getBonusNumber());
    }
}
