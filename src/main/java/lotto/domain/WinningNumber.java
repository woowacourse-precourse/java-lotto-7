package lotto.domain;


public class WinningNumber {
    private Lotto numbers;
    private int bonus;

    public WinningNumber(Lotto numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public Prize matchCount(Lotto lotto) {
        int count = (int)numbers.getNumbers().stream().filter(lotto::contains).count();
        boolean bonusMatch = lotto.contains(bonus);

        return Prize.winningMatch(count, bonusMatch);
    }
}
