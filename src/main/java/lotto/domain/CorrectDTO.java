package lotto.domain;

import java.util.List;

public class CorrectDTO {
    private Lotto corrects;
    private int bonus;

    public CorrectDTO(Lotto corrects) {
        this.corrects = corrects;
    }

    public Lotto getCorrects() {
        return corrects;
    }

    public void setCorrects(Lotto corrects) {
        this.corrects = corrects;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        checkForUpperBound(bonus);
        checkForDuplicate(corrects, bonus);
        this.bonus = bonus;
    }

    private void checkForUpperBound(int bonus) {
        if (bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 45이하의 숫자여야 합니다.");
        }
    }

    private void checkForDuplicate(Lotto corrects, int bonus) {
        if (corrects.getLotto().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되어서는 안됩니다.");
        }
    }
}
