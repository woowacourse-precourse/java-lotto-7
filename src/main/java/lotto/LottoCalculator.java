package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {
    private final List<List<Integer>> generatedTickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int totalSpent;
    private long totalPrizeAmount = 0;
    private final Map<Prize, Integer> prizeCount = new HashMap<>();

    private enum Prize {
        FIRST(6, 2_000_000_000, false),
        SECOND(5, 30_000_000, true),
        THIRD(5, 1_500_000, false),
        FOURTH(4, 50_000, false),
        FIFTH(3, 5_000, false);

        private final int matchCount;
        private final int prizeAmount;
        private final boolean requiresBonus;

        Prize(int matchCount, int prizeAmount, boolean requiresBonus) {
            this.matchCount = matchCount;
            this.prizeAmount = prizeAmount;
            this.requiresBonus = requiresBonus;
        }

        public boolean matches(int matchCount, boolean bonusMatch) {
            return this.matchCount == matchCount && (!requiresBonus || bonusMatch);
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }

        public String getDescription() {
            return matchCount + "개 일치" + (requiresBonus ? ", 보너스 번호 일치" : "") + " (" + prizeAmount + "원)";
        }
    }

    public LottoCalculator(List<List<Integer>> generatedTickets, List<Integer> winningNumbers, int bonusNumber, int totalSpent) {
        this.generatedTickets = generatedTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.totalSpent = totalSpent;
        initializePrizeCount();
    }

    public void calculateResults() {
        for (List<Integer> ticket : generatedTickets) {
            int matchCount = countMatches(ticket, winningNumbers);
            boolean bonusMatch = ticket.contains(bonusNumber);
            allocatePrize(matchCount, bonusMatch);
        }
    }

    private void allocatePrize(int matchCount, boolean bonusMatch) {
        for (Prize prize : Prize.values()) {
            if (prize.matches(matchCount, bonusMatch)) {
                prizeCount.put(prize, prizeCount.get(prize) + 1);
                totalPrizeAmount += prize.getPrizeAmount();
                break;
            }
        }
    }

    private int countMatches(List<Integer> ticket, List<Integer> winningNumbers) {
        int matches = 0;
        for (int number : ticket) {
            if (winningNumbers.contains(number)) {
                matches++;
            }
        }
        return matches;
    }

    private void initializePrizeCount() {
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
    }

    public double calculateReturnRate() {
        return ((double) totalPrizeAmount / totalSpent) * 100;
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public long getTotalPrizeAmount() {
        return totalPrizeAmount;
    }

    public void displayResults() {
        System.out.println("당첨 내역을 출력한다.");
        System.out.println("\n");
        for (Prize prize : Prize.values()) {
            int count = prizeCount.get(prize);
            System.out.println(prize.getDescription() + " - " + count + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", calculateReturnRate());
    }

}
