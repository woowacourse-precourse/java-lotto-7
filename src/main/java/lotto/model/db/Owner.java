package lotto.model.db;

import static lotto.constant.UserId.OWNER;

import lotto.constant.UserId;

public class Owner implements User {

    private final UserId id;
    private Lotto winningLotto;
    private Integer bonus;

    private Owner(UserId id, Lotto winningLotto, Integer bonus) {
        this.id = id;
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public static Owner from(Lotto winningLotto, int bonus) {
        return new Owner(OWNER, winningLotto, bonus);
    }

    @Override
    public UserId getId() {
        return id;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonus() {
        return bonus;
    }
}
