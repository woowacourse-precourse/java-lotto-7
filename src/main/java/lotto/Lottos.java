package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public long getSize() {
        return lottos.size();
    }

    public String result() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Lotto lotto : lottos) {
            stringJoiner.add(lotto.result());
        }
        return stringJoiner.toString();
    }
}
