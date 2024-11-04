package lotto.repository;

import java.util.LinkedList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {
    private final List<Lotto> lottos = new LinkedList<>();

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> findAll() {
        return lottos;
    }
}
