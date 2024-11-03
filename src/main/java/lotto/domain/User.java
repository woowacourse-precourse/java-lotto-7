package lotto.domain;

import java.util.List;

public class User {
    private String money;
    private int numOfLottos;
    private List<Lottos> lottos;

    public User() {

    }

    public User(String money, int numOfLottos, List<Lottos> lottos) {
        this.money = money;
        this.numOfLottos = numOfLottos;
        this.lottos = lottos;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setNumOfLottos() {
        this.numOfLottos = getMoney() / 1000;
    }

    public int getMoney() {
        return Integer.parseInt(money);
    }

    public int getNumOfLottos() {
        return this.numOfLottos;
    }
}
