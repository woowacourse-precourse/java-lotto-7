package lotto.util;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.PrizeTier;

public class PrizeCalculator {

    private int bonusNumber;

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    // 구매한 티켓에 대한 당첨 결과 계산
    public List<PrizeTier> calculateResults(List<Lotto> tickets, Lotto winningLotto) {
        return tickets.stream()
                .map(ticket -> determinePrize(ticket, winningLotto))
                .toList();
    }

    private PrizeTier determinePrize(Lotto ticket, Lotto winningLotto) {
        int matchCount = ticket.getMatchCount(winningLotto.getNumbers());
        boolean bonusMatch = ticket.containsBonus(bonusNumber);
        return PrizeTier.findPrize(matchCount, bonusMatch).orElse(PrizeTier.NONE);
    }

    public double calculateProfitRate(List<PrizeTier> prizeResults, int purchaseAmount) {
        int totalPrize = calculateTotalPrize(prizeResults);
        return roundToTwoDecimalPlaces((double) totalPrize / purchaseAmount * 100);
    }

    private int calculateTotalPrize(List<PrizeTier> prizeResults) {
        return prizeResults.stream()
                .mapToInt(PrizeTier::getPrizeAmount)
                .sum();
    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}
