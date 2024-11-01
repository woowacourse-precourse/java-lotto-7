package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<List<Integer>> lottoContents) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> content : lottoContents) {
            lottos.add(Lotto.createLotto(content));
        }
        this.lottos = lottos;
    }
}
