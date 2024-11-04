package lotto;

public class LottoBonus {
    private final Lotto lotto;
    private final int bonus;

    public LottoBonus(Lotto lotto, int bonus) throws IllegalArgumentException {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }

    private void validate(Lotto lotto, int bonus) throws IllegalArgumentException {
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
        if (bonus < 0 || bonus > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
