package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotties {
    private int count;
    private int cost;
    private final List<Lotto> lotties;

    public Lotties() {
        this.count = 0;
        this.cost = 0;
        this.lotties = new ArrayList<>();
    }

    public List<Lotto> getLotties() {
        return new ArrayList<>(lotties);
    }

    public void addLotto(List<Integer> numbers) {
        count += 1;
        cost += 1000;
        lotties.add(new Lotto(numbers));
    }

    public int getCost() {
        return cost;
    }
}