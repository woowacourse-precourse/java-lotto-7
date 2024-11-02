package lotto.domain;

public class Bonus {

    private static final Integer MIN_NUMBER_RANGE = 1;
    private static final Integer MAX_NUMBER_RANGE = 45;

    private final Integer bonus;

    public Bonus(Integer bonus) {
        validateRange(bonus);
        this.bonus = bonus;
    }

    private boolean IsNumberRangeIncorrect(Integer bonus) {
        return bonus < MIN_NUMBER_RANGE && bonus > MAX_NUMBER_RANGE;
    }

    private void validateRange(Integer bonus) {
        if (IsNumberRangeIncorrect(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getBonus() {
        return bonus;
    }
}
