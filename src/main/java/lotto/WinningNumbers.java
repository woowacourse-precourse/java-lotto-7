package lotto;

public class WinningNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lotto lotto;
    private final int bonus;

    public WinningNumbers(Lotto lotto, int bonus) {
        this.lotto = lotto;
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus) {
        validateNumberRange(bonus);
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}