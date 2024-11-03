package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos randomFrom(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(Lotto.randomCreate());
        }

        return new Lottos(lottos);
    }

    public boolean isSize(int size) {
        return this.lottos.size() == size;
    }

}
