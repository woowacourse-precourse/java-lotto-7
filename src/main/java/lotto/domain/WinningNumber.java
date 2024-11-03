package lotto.domain;


import static lotto.ui.ErrorMessage.ERROR_OVERLAP_BONUS_AND_WINNING;

public class WinningNumber {
    private Lotto numbers;
    private int bonus;

    public WinningNumber(Lotto numbers, int bonus) {
        numbersValid(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public Prize matchCount(Lotto lotto) {
        int count = (int)numbers.getNumbers().stream().filter(lotto::contains).count();
        boolean bonusMatch = lotto.contains(bonus);

        return Prize.winningMatch(count, bonusMatch);
    }

    private void numbersValid(Lotto numbers, int bonus) {
        if(numbers.contains(bonus))
            throw new IllegalArgumentException(ERROR_OVERLAP_BONUS_AND_WINNING);
    }
}
