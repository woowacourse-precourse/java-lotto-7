package lotto;

import java.util.List;

public class LottoPaper {
    private final List<Lotto> values;

    public LottoPaper(List<Lotto> values) {
        this.values = values;
    }

    public void searchAll(List<Integer> winNumbers, int bonus) {
        values.forEach(lotto -> lotto.search(winNumbers, bonus));
    }

    public List<Lotto> getValues() {
        return values;
    }
}