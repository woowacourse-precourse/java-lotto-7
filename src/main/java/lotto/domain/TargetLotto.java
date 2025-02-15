package lotto.domain;

import lotto.Constants;

public record TargetLotto(Lotto lotto, int bonus) {

    public static final int MIN_LOTTO_NUMBER = Constants.MIN_LOTTO_NUMBER;
    public static final int MAX_LOTTO_NUMBER = Constants.MAX_LOTTO_NUMBER;

    public TargetLotto(Lotto lotto, int bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, int bonus) {
        if (bonus < MIN_LOTTO_NUMBER || bonus > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + MIN_LOTTO_NUMBER
                    + " ~ " + MAX_LOTTO_NUMBER + " 45사이의 숫자여야 합니다.");
        }

        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 달라야 합니다.");
        }
    }
}
