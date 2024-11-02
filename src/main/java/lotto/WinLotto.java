package lotto;

import java.util.Objects;

public class WinLotto {
    private final Lotto lotto;
    private final Integer bonus;

    public WinLotto(Lotto lotto, Integer bonus) {
        validate(lotto, bonus);
        validate(bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public void validate(Lotto lotto, Integer bonus) {
        for (Integer number : lotto.getNumbers()) {
            if (Objects.equals(number, bonus)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호와 로또 번호가 같습니다.");
            }
        }
    }

    public void validate(Integer bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1~45 사이입니다.");
        }
    }
}
