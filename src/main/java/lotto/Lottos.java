package lotto;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<List<Integer>> lottoNumbers) {
        return new Lottos(lottoNumbers.stream().map(Lotto::new).collect(Collectors.toList()));
    }

    public Iterator<Lotto> getLottos() {
        return lottos.iterator();
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
