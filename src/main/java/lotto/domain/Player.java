package lotto.domain;

import java.util.List;

public class Player {

    private final List<Lotto> lottos;
    private final int money;

    public Player(List<Lotto> lottos, int money) {
        this.lottos = lottos;
        this.money = money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }
}
