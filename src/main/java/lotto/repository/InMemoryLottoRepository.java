package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;

public class InMemoryLottoRepository implements LottoRepository {
    private final List<Lotto> lottos = new ArrayList<>();
    private static final InMemoryLottoRepository INSTANCE = new InMemoryLottoRepository();

    private InMemoryLottoRepository() {

    }

    public static InMemoryLottoRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    @Override
    public List<Lotto> findAllLotto() {
        return new ArrayList<>(lottos);
    }

    @Override
    public void clear() {
        lottos.clear();
    }
}
