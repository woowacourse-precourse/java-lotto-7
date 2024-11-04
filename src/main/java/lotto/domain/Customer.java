package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

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

    public Lottos purchaseLottos() {
        IntStream.rangeClosed(1, price.getCount())
                .mapToObj(i -> Lotto.from(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .forEach(lotto -> lottos.addLotto(lotto));
        return lottos;
    }
}
