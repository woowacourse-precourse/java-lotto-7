package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.PrizeTier;

public class PrizeCalculator {


    private PrizeTier determinePrize(Lotto ticket, Lotto winningLotto, int bonusNumber) {
        int matchCount = ticket.getMatchCount(winningLotto.getNumbers());
        boolean bonusMatch = ticket.containsBonus(bonusNumber);
        return PrizeTier.findPrize(matchCount, bonusMatch);
    }


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
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return roundToTwoDecimalPlaces(profitRate);
    }


    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}
