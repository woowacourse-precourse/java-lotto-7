package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private final List<Lotto> store = new ArrayList<>();

    public Lotto save(Lotto lotto) {
        store.add(lotto);
        return lotto;
    }

    public List<Lotto> findAll() {
        return List.copyOf(store);
    }
}
