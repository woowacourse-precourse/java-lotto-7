package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.PrizeTier;

public class PrizeCalculator {

    public List<PrizeTier> calculateResults(List<Lotto> tickets, Lotto winningLotto, int bonusNumber) {
        return tickets.stream()
                .map(ticket -> determinePrize(ticket, winningLotto, bonusNumber))
                .toList();
    }

    public int calculateTotalPrize(List<PrizeTier> prizeResults) {
        return prizeResults.stream()
                .mapToInt(PrizeTier::getPrizeAmount)
                .sum();
    }

    public double calculateProfitRate(int totalPrize, int purchaseAmount) {
        double profitRate = computeProfitRate(totalPrize, purchaseAmount);
        return roundToTwoDecimalPlaces(profitRate);
    }

    private PrizeTier determinePrize(Lotto ticket, Lotto winningLotto, int bonusNumber) {
        int matchCount = calculateMatchCount(ticket, winningLotto);
        boolean bonusMatch = isBonusMatch(ticket, bonusNumber);
        return PrizeTier.findPrize(matchCount, bonusMatch);
    }

    private int calculateMatchCount(Lotto ticket, Lotto winningLotto) {
        return ticket.getMatchCount(winningLotto.getNumbers());
    }

    private boolean isBonusMatch(Lotto ticket, int bonusNumber) {
        return ticket.containsBonus(bonusNumber);
    }

    private double computeProfitRate(int totalPrize, int purchaseAmount) {
        return (double) totalPrize / purchaseAmount * 100;
    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}

