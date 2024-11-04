package lotto;

import lotto.enums.Rank;

import java.util.List;

public class LottoWinningChecker {
    private final List<Lotto> tickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private int firstPlaceCount = 0;
    private int secondPlaceCount = 0;
    private int thirdPlaceCount = 0;
    private int fourthPlaceCount = 0;
    private int fifthPlaceCount = 0;

    public LottoWinningChecker(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        matchTicketsWithWinningNumbers();
    }

    public List<Integer> getPlaceCount() {
        return List.of(firstPlaceCount, secondPlaceCount, thirdPlaceCount, fourthPlaceCount, fifthPlaceCount);
    }

    private void matchTicketsWithWinningNumbers() {
        for (Lotto ticket : tickets) {
            boolean isBonusIncluded = checkBonusIncluded(ticket);
            ticket.getNumbers().retainAll(winningNumbers);
            checkRank(ticket.getNumbers().size(), isBonusIncluded);
        }
    }

    private boolean checkBonusIncluded(Lotto ticket) {
        return ticket.getNumbers().contains(bonusNumber);
    }

    private void checkRank(int matchingCount, boolean isBonusIncluded) {
        if (matchingCount == Rank.FIRST_PLACE.getMatchCount()) {
            firstPlaceCount++;
        } else if (isBonusIncluded && matchingCount == Rank.SECOND_PLACE.getMatchCount()) {
            secondPlaceCount++;
        } else if (matchingCount == Rank.THIRD_PLACE.getMatchCount()) {
            thirdPlaceCount++;
        } else if (matchingCount == Rank.FOURTH_PLACE.getMatchCount()) {
            fourthPlaceCount++;
        } else if (matchingCount == Rank.FIFTH_PLACE.getMatchCount()) {
            fifthPlaceCount++;
        }
    }
}
