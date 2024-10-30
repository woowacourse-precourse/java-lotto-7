package lotto.domain;

public class User {
    private Money money;
    private Lottos lottos;

    public User(Money money, Lottos lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Money getMoney() {
        return money;
    }
}
