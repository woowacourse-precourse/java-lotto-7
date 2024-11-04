package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class InMemoryLottoRepository implements LottoRepository {

    private final List<Lotto> storedLotto;

    public InMemoryLottoRepository() {
        this.storedLotto = new ArrayList<>();
    }

    @Override
    public void saveAll(List<Lotto> lottoList) {
        storedLotto.addAll(lottoList);
    }

    @Override
    public List<Lotto> findAll() {
        return storedLotto;
    }

}
