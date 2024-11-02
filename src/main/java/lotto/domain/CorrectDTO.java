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
        this.bonus = bonus;
    }

    //여기에 validate를 추가해서 넣어줘야 한다.
}
