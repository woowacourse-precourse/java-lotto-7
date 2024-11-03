package lotto.back.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.back.domain.Lotto;

public class LottoRepository {
    private final List<Lotto> lottos = new ArrayList<>();

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> find() {
        return lottos.stream().toList();
    }
}
