package lotto.domain;


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
            throw new IllegalArgumentException("[ERROR] 당첨번호에 보너스번호가 포함되어 있습니다.");
    }
}
