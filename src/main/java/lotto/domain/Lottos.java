package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final int price;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        this.price = lottos.size() * 1000;
    }

    public static Lottos from(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(integers));
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public int getPrice() {
        return price;
    }
}
