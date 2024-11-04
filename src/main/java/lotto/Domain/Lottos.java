package lotto.Domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(Lotto.create());
        }

        return new Lottos(lottos);
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public List<Lotto> getLottoList() {
        return new ArrayList<>(lottos);
    }

}
