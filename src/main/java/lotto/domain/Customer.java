package lotto.domain;

import java.util.List;

public class Customer {

    private final Price price;
    private final Lottos lottos;

    private Customer(int value) {
        this.price = Price.from(value);
        this.lottos = Lottos.from();
    }

    private Customer(int value, List<Lotto> values) {
        this.price = Price.from(value);
        this.lottos = Lottos.from(values);
    }

    public static Customer from(int value) {
        return new Customer(value);
    }

    public static Customer of(int value, List<Lotto> values) {
        return new Customer(value, values);
    }

    public Price getPrice() {
        return price;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
