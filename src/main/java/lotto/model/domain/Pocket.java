package lotto.model.domain;

import java.util.List;

public class Pocket {
    List<Lotto> lottos;
    int money;

    public Pocket(List<Lotto> lottos,int money) {
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
