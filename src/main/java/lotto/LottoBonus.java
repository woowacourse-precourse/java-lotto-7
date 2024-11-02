package lotto;

public class LottoBonus {
    private final int bonus;

    public LottoBonus(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    private void validate(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.");
        }
        // todo : winning number와 중복되지않아야함
    }
}
