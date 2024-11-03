package lotto;

import java.util.List;

public class Lottos {
    List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public void searchAll(List<Integer> winNumbers, int bonus) {
        values.forEach(lotto -> lotto.search(winNumbers, bonus));
    }

}