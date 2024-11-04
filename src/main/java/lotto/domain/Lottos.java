package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> values;

    private Lottos() {
        this.values = new ArrayList<>();
    }

    private Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos from() {
        return new Lottos();
    }

    public static Lottos from(List<Lotto> values) {
        return new Lottos(values);
    }

    public List<Lotto> getValues() {
        return values;
    }

    public void addLotto(Lotto lotto) {
        values.add(lotto);
    }
}
