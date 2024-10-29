package lotto.domain;

import java.util.List;

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

    public Rank check(Lotto win, int winBonus) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = win.getNumbers();

        int matchCount = getMatchCount(numbers, winningNumbers);
        boolean matchBonus = isBonusMatch(winBonus);

        return Rank.valueOf(matchCount, matchBonus);
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
