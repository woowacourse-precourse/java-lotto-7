package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private static final List<Lotto> store = new ArrayList<>();
    private static final LottoRepository instance = new LottoRepository();

    public static LottoRepository getInstance() {
        return instance;
    }

    private LottoRepository() {
    }

    public Lotto save(Lotto lotto) {
        store.add(lotto);
        return lotto;
    }

    public List<Lotto> findAll() {
        return store;
    }

    public int size() {
        return store.size();
    }
}
