package lotto.model;

public class Winning {
    private final Lotto winningLotto;
    private final Bonus bonus;

    public Winning(Lotto winningLotto, Bonus bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public int match(Lotto lotto){
        long matchCount = lotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .count();
        return (int)matchCount;
    }

    public boolean isBonusMatch(Lotto lotto){
        return lotto.getNumbers().stream()
                .anyMatch(bonus::isMatch);
    }

}
