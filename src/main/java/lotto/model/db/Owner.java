package lotto.model.db;

import static lotto.constant.UserId.SYSTEM;

import lotto.Lotto;
import lotto.constant.UserId;

public class Owner implements User {

    private UserId id;
    private Lotto lotto;
    private Integer bonus;

    private Owner(UserId id, Lotto lotto, Integer bonus) {
        this.id = id;
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static Owner from(Lotto lotto, int bonus) {
        return new Owner(SYSTEM, lotto, bonus);
    }

    @Override
    public UserId getId() {
        return id;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
