package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties() {
        this.lotties = new ArrayList<>();
    }

    public List<Lotto> getLotties() {
        return new ArrayList<>(lotties);
    }

    public void addLotto(List<Integer> numbers) {
        lotties.add(new Lotto(numbers));
    }
}