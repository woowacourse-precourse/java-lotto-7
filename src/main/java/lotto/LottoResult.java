package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> resultMap = new HashMap<>();
    private final LottoTickets purchasedTickets;
    private final WinningLotto winningLotto;

    public LottoResult(LottoTickets purchasedTickets, WinningLotto winningLotto) {
        this.purchasedTickets = purchasedTickets;
        this.winningLotto = winningLotto;
        initializeResultMap();
        calculateResult();
    }

    private void calculateResult() {
        for (Lotto lotto : purchasedTickets.getTickets()) {
            int matchCount = countMatchingNumbers(lotto);
            boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());
            Rank rank = Rank.getRank(matchCount, bonusMatch);
            if (rank != null) {
                resultMap.put(rank, resultMap.get(rank) + 1);
            }
        }
    }

    private int countMatchingNumbers(Lotto lotto) {
        int count = 0;
        for (int num : lotto.getNumbers()) {
            if (winningLotto.getWinningNumbers().getNumbers().contains(num)) {
                count++;
            }
        }
        return count;
    }

    private void initializeResultMap() {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void printResult() {
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;
            String message = rank.getMatchCount();
            message += " (" + rank.getPrize() + "원) - " + resultMap.get(rank) + "개";
            System.out.println(message);
        }
    }

    public void printProfitRate(int purchaseAmount) {
        double totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrizeMoney() * resultMap.get(rank);
        }
        double profitRate = (totalPrize / purchaseAmount) * 100;
        profitRate = Math.round(profitRate * 10) / 10.0;
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }

    public double calculateProfitRate(int purchaseAmount) {
        double totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrizeMoney() * resultMap.get(rank);
        }
        double profitRate = (totalPrize / purchaseAmount) * 100;
        profitRate = Math.round(profitRate * 100) / 100.0;
        return profitRate;
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }
}
