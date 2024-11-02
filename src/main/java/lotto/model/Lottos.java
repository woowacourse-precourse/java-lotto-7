package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos purchase(int purchaseCount){
        List<Lotto> purchasedLottos = IntStream.range(0, purchaseCount)
                .mapToObj(lotto -> new RandomLottoGenerator().generateLotto())
                .toList();
        return new Lottos(purchasedLottos);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
