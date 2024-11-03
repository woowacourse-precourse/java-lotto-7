package lotto.domain.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class InMemoryLottoRepository implements LottoRepository {

    private static final InMemoryLottoRepository INSTANCE = new InMemoryLottoRepository();

    private final List<Lotto> lottoRepository = new ArrayList<>();

    private InMemoryLottoRepository() {

    }

    public static InMemoryLottoRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void saveAll(List<Lotto> lottos) {
        lottoRepository.addAll(lottos);
    }

    @Override
    public List<Lotto> getAll() {
        return lottoRepository.stream().toList();
    }
}
