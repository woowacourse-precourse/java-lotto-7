package lotto.domain;

import lotto.enumtype.Rank;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(LottoTicket ticket) {
        int matchCount = getMatchCount(ticket);
        boolean bonusMatch = isBonusMatch(ticket);

        return Rank.valueOf(matchCount, bonusMatch);
    }

    private int getMatchCount(LottoTicket ticket) {
        List<Integer> ticketNumbers = ticket.getLotto().getNumbers();
        int count = 0;
        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBonusMatch(LottoTicket ticket) {
        return ticket.getLotto().getNumbers().contains(bonusNumber);
    }
}
