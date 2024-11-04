package lotto;

public class Person {
    private Lottos lottos;
    private Money money;

    public Person(Money money) {
        this.money = money;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public void setLottos(Lottos lottos) {
        this.lottos = lottos;
    }

    public Money pay() {
        return money;
    }
}
