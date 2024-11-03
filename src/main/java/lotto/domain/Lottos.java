package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<List<Integer>> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public void addLottoToList(List<Integer> numbers) {
        lottos.add(numbers);
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
