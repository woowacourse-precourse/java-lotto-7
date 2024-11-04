package lotto.model;

import static lotto.constant.LottoValue.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private int cost;
    private final List<Lotto> lottos;

    public Lottos() {
        this.cost = 0;
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public void addLotto(List<Integer> numbers) {
        cost += LOTTO_PRICE.getValue();
        lottos.add(new Lotto(numbers));
    }
}