package lotto;

public class LottoBonus {
    private final int bonus;

    public LottoBonus(int bonus, Lotto winningLotto) {
        validate(bonus, winningLotto);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    private void validate(int bonus, Lotto winningLotto) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.");
        }

        boolean isDuplicated = winningLotto.getNumbers().contains(bonus);
        if (isDuplicated) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }
}
