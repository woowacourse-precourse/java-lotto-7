package lotto.back.lotto.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class Lottos {

    private final UUID uuid;

    private final List<Lotto> lottos;
    
    private final Integer price;

    private Lottos(UUID uuid, List<Lotto> lottos, Integer price) {
        this.uuid = uuid;
        this.lottos = lottos;
        this.price = price;
    }


    public static Lottos generateRandomLottos(Integer count, Integer price) {
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> Lotto.generateRandomLotto())
                .toList();

        return new Lottos(UUID.randomUUID(), lottos, price);
    }


    public UUID getUuid() {
        return uuid;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer getPrice() {
        return price;
    }
}
