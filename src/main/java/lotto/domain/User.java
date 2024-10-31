package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class User {
    private String money;
    private int numOfLottos;
    private List<Lotto> lottos;

    public User() {

    }

    public User(String money, int numOfLottos, List<Lotto> lottos) {
        this.money = money;
        this.numOfLottos = numOfLottos;
        this.lottos = lottos;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
