package lotto.domain;

public class Bonus {
    private final int bonusNumber;

    private Bonus(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static Bonus create(int bonusNumber) {
        return new Bonus(bonusNumber);
    }
}
