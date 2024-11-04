package lotto;

import java.util.List;

public class LottoWinningChecker {
    private static final int FIRST_PLACE_MATCH_COUNT = 6;
    private static final int SECOND_AND_THIRD_PLACE_MATCH_COUNT = 5;
    private static final int FOURTH_PLACE_MATCH_COUNT = 4;
    private static final int FIFTH_PLACE_MATCH_COUNT = 3;
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
            ticket.getNumbers().retainAll(winningNumbers);
            checkRank(ticket.getNumbers().size(), checkBonusIncluded(ticket));
        }
    }

    private boolean checkBonusIncluded(Lotto ticket) {
        return ticket.getNumbers().contains(bonusNumber);
    }

    private void checkRank(int matchingCount, boolean isBonusIncluded) {
        if (matchingCount == FIRST_PLACE_MATCH_COUNT) {
            firstPlaceCount++;
        } else if (isBonusIncluded && matchingCount == SECOND_AND_THIRD_PLACE_MATCH_COUNT) {
            secondPlaceCount++;
        } else if (matchingCount == SECOND_AND_THIRD_PLACE_MATCH_COUNT) {
            thirdPlaceCount++;
        } else if (matchingCount == FOURTH_PLACE_MATCH_COUNT) {
            fourthPlaceCount++;
        } else if (matchingCount == FIFTH_PLACE_MATCH_COUNT) {
            fifthPlaceCount++;
        }
    }
}
