package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.MISS;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static lotto.domain.Rank.values;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.EnumMap;
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

    private EnumMap<Rank, Integer> initRankMap() {
        EnumMap<Rank, Integer> rankMap = new EnumMap<>(Rank.class);
        Arrays.stream(values()).forEach(rank -> rankMap.put(rank, 0));
        return rankMap;
    }
}
