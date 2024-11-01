package lotto.domain.ticket;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.global.common.Rank;

public class Ticket {

    private final Lotto lotto;
    private final int bonus;

    private Ticket(final Lotto lotto, final int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static Ticket of(final List<Integer> numbers, final int bonus) {
        return new Ticket(new Lotto(numbers), bonus);
    }

    public Rank check(Ticket winningTicket) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningTicket.getNumbers();

        int matchCount = getMatchCount(numbers, winningNumbers);
        boolean matchBonus = isBonusMatch(winningTicket.getBonusNumber());

        return Rank.valueOf(matchCount, matchBonus);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonus;
    }

    private int getMatchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusMatch(int winBonus) {
        return bonus == winBonus;
    }
}
