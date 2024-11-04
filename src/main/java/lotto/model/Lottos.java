package lotto.model;

import java.util.List;
import java.util.StringJoiner;

public class Lottos {
    private static final String NEXT_LINE = "\n";
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Lotto get(int idx) {
        return lottos.get(idx);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(NEXT_LINE);
        lottos.forEach(lotto -> sj.add(lotto.toString()));
        return sj.toString();
    }
}
