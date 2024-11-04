package lotto;

import java.util.List;

public class MatchCalculator {
    MatchCount calculateMatchCount(Lotto winning, Lotto ticket, int bonusNumber) {
        List<Integer> winningNumbers = winning.getNumbers();
        List<Integer> ticketNumbers = ticket.getNumbers();

        long count = ticketNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean bonus = ticketNumbers.contains(bonusNumber);

        if (count == 3)
            return MatchCount.THREE_MATCH;
        if (count == 4)
            return MatchCount.FOUR_MATCH;
        if (count == 5 && bonus)
            return MatchCount.FIVE_MATCH_WITH_BONUS_NUMBER;
        if (count == 5)
            return MatchCount.FIVE_MATCH;
        if (count == 6)
            return MatchCount.SIX_MATCH;

        return MatchCount.NOT_MATCH;
    }

    public double calculateYield(int purchasePrice, int winningMoney){
       return (double)winningMoney/purchasePrice * 100;
    }
}
