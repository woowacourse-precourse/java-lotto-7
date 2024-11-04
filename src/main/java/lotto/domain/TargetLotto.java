package lotto.domain;

public record TargetLotto(Lotto lotto, int bonus) {

    public TargetLotto(Lotto lotto, int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45사이의 숫자여야 합니다.");
        }
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 달라야 합니다.");
        }
        this.lotto = lotto;
        this.bonus = bonus;
    }
}
