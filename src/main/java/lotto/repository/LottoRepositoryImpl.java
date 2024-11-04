package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoRepositoryImpl implements LottoRepository {

    private List<Lotto> storage = new ArrayList<>();

    @Override
    public void save(Lotto lotto) {
        storage.add(lotto);
    }

    @Override
    public int count() {
        return storage.size();
    }

    @Override
    public List<Lotto> findAll() {
        return new ArrayList<>(storage);
    }
}
